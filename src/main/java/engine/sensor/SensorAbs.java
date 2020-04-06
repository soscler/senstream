package engine.sensor;


import engine.SensorException;
import engine.generator.FrequencyGenerator;
import engine.generator.Generators;
import engine.measure.Measure;
import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public abstract class SensorAbs<T extends Measure> implements Sensor<T> {

    private final long id;
    private boolean isOn = false;
    private String name;
    private String location;
    private long frequencySecs;
    private FrequencyGenerator<Double> generator;
    private T measure;
    private OutputStream out = System.out;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    SensorAbs(long id, double min, double max, long frequencySecs) {
        this.id = id;
        this.frequencySecs = frequencySecs;
        this.generator = Generators.doubleRandomFrequencyGenerator(frequencySecs, min, max);
    }

    SensorAbs(long id, FrequencyGenerator<Double> generator) {
        this.id = id;
        this.generator = generator;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
        this.measure.resolve(null);
        generator.stop();
        this.executorService.shutdownNow();
    }

    @Override
    public void start() throws InterruptedException, SensorException {
        if(!isOn) {
            throw new SensorException("Sensor is not started");
        }
        generator.start();
        executorService.submit(() -> {
            while (isOn) {
                try {
                    Thread.sleep(frequencySecs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                Double value = generator.getValue();
                measure.resolve(value);
            }
        });
    }

    @Override
    public void display() throws SensorException, IOException {
        String msg;
        if (! isOn ) throw new SensorException("Sensor is not started");
        if(measure == null) {
            msg = "Sensor: " + id + "No data to show, please make sure the sensor is working\n";
        }
        else msg = "Sensor: " + id + "\n" + measure.toJson() + "\n";
        out.write(msg.getBytes());
        out.flush();

    }

    public T getCurrentMeasure() {
        return this.measure;
    }

}
