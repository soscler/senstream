package engine;

/**
 * TODO: Create a display interface so that a sensor can display its data to a generic display
 * Display can be STDOUT or whatever display that can handle the data
 * @throws SensorException
 */
public interface Sensor <T extends Measure> {

    void on();
    T measure() throws SensorException;
    void off();
    void start() throws InterruptedException, SensorException;
    void display() throws SensorException;
    Measure getCurrentMeasure();

}
