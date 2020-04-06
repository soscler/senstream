package engine;

import engine.measure.Measure;
import engine.sensor.Sensor;

/**
 * An IOT System is a system composed of multiple sensor
 */
public interface IOTSystem {

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

    public void display();

    public void register(Sensor<? extends Measure> sensor);
}
