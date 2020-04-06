package engine.sensor;

import engine.SensorException;
import engine.measure.Measure;

import java.io.IOException;

/**
 * TODO: Create a display interface so that a sensor can display its data to a generic display
 * Display can be STDOUT or whatever display that can handle the data
 */
public interface Sensor <T extends Measure> {

    void on();

    /**
     * Turn off the sensor
     * Make measure null so that Java Garbage Collector can free the memory
     */
    void off();

    /**
     * Start the measurement process. This will turn on the sensor
     * @throws InterruptedException
     * @throws SensorException
     */
    void start() throws InterruptedException, SensorException;

    /**
     * Display the current measurement
     * @throws SensorException
     */
    void display() throws SensorException, IOException;

    /**
     *
     * @return
     */
    T getCurrentMeasure();

}
