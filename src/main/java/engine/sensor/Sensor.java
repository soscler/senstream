package engine.sensor;

import engine.SensorException;
import engine.measure.Measure;

/**
 * TODO: Create a display interface so that a sensor can display its data to a generic display
 * Display can be STDOUT or whatever display that can handle the data
 */
public interface Sensor <T extends Measure> {

    void on();
    T measure() throws SensorException;

    /**
     * Turn off the sensor
     * Make measure null so that Java Garbage Collector can free the memory
     */
    void off();

    /**
     * Start the measurement process. This will turn on the sensor
     * @throws InterruptedException
     * @throws SensorException
     * FIXME: Move the Thread run method here
     */
    void start() throws InterruptedException, SensorException;

    /**
     * Display the current measurement
     * @throws SensorException
     */
    void display() throws SensorException;

    /**
     *
     * @return
     */
    Measure getCurrentMeasure();

}
