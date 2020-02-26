package engine;


import lombok.Data;

import java.time.Duration;

@Data
public abstract class SensorAbs<T extends Measure> implements Sensor<T> {

    private final long id;
    private boolean isOn = false;
    private String name;
    private String location;
    private double minValue;
    private double maxValue;
    private long frequencySecs;

    // Always content the current measure if on, or null if off
    private Measure measure = null;

    SensorAbs(long id, double min, double max, long frequencySecs) {
        this.id = id;
        this.minValue = min;
        this.maxValue = max;
        this.frequencySecs = frequencySecs;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    /**
     * Turn off the sensor
     * Make measure null so that Java Garbage Collector can free the memory
     */
    @Override
    public void off() {
        this.isOn = false;
        this.measure =  null;
    }

    /**
     * Start the measurement process. This will turn on the sensor
     * @throws InterruptedException
     * @throws SensorException
     * FIXME: Move the Thread run method here
     */
    @Override
    public void start() throws InterruptedException, SensorException {
        on(); // Start the sensor if not started
        while (isOn) {
            Thread.sleep(Duration.ofSeconds(frequencySecs).toMillis());
            measure();
        }
    }

    /**
     * Display the current measurement
     * @throws SensorException
     */
    @Override
    public void display() throws SensorException {
        //if (! isOn ) throw new SensorException("Sensor is off");
        System.out.println("Sensor: " + id);
        if(measure == null) {
            if(isOn) System.out.println("No data to show, please make sure the sensor is working");
            else System.out.println("No data to show, please start the sensor");
        }
        else System.out.println(measure.toString());
    }

    public Measure getCurrentMeasure() {
        return this.measure;
    }

}
