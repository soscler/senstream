package com.tsimul;

import com.tsimul.device.sensor.Sensor;
import com.tsimul.event.Observable;
import com.tsimul.event.Observer;
import com.tsimul.measure.Measure;
import com.tsimul.plugin.Plugin;

/**
 * An IOT System is a system composed of multiple sensor
 */
public interface IOTSystem extends Observable, Observer {

    /**
     * Turn on the system
     * This will try to turn on all the sensors inside the system
     */
    public void start();

    /**
     * Turn off the system
     * This will try to turn off all the sensors inside the system
     */
    public void stop();

    /**
     * Display useful information of the system
     */
    public void display();

    /**
     * TODO: Create an interface Pluggable to unify any component that can be plugged to the system
     * Should we separate simulated hardware from software
     */

    /**
     * Add a new sensor to the system
     * @param sensor the sensor to be added to the system
     */
    public void register(Sensor<? extends Measure> sensor);

    /**
     * Remove a sensor from the system
     * @param sensor the sensor to be removed from the system
     */
    public void deregister(Sensor<? extends Measure> sensor);

    /**
     * Register a new plugin to the system
     */
    default void plugin(Plugin p) {
        throw new UnsupportedOperationException("The system does not support plugins");
    }

    /**
     * De-register a plugin from the system
     */
    default void unplug(Plugin p) {
        throw new UnsupportedOperationException("The system does not support plugins");
    }

    default String toJson() {
        throw new UnsupportedOperationException("This plugin does not support this method yet");
    }

    /**
     * This method is called whenever there is an event in a device
     * Then the system decides either or not to send the event to a plugin
     */
    default public void update() {}

    /**
     * TODO: Complete the interface with useful methods for the system
     * - get(String id) // Get the sensor with id @id
     * - stop(String id) // Turn off the sensor with id @id
     * - start(String id) // Turn on the sensor with id @id
     * - details() // return a human readable details of the system
     * - destroy(String id) // remove a sensor from the system and delete it
     * - autoDestroy() // remove and destroy all the components of the system, and then destroy the system itself.
     * // autoDestroy is an expensive operation
     * // Guarantee : The system will be destroyed
     */
}