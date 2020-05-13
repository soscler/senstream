package com.tsimul.device.sensor;


import com.tsimul.device.AbstractDevice;
import com.tsimul.event.Event;
import com.tsimul.exception.SensorException;
import com.tsimul.generator.FrequencyGenerator;
import com.tsimul.generator.Generators;
import com.tsimul.measure.Measure;
import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public abstract class AbstractSensor<T extends Measure> extends AbstractDevice implements Sensor<T> {

    private final long id;
    private boolean isOn = false;
    private String name;
    private String location;
    private long millis;
    private FrequencyGenerator<Double> generator;
    private T measure;
    private OutputStream out = System.out;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    AbstractSensor(long id, double min, double max, long millis) {
        super();
        this.id = id;
        this.millis = millis;
        this.generator = Generators.doubleRandomFrequencyGenerator(millis, min, max);
    }

    AbstractSensor(long id, FrequencyGenerator<Double> generator) {
        this.id = id;
        this.generator = generator;
    }

    @Override
    public void on() {
        this.isOn = true;
        this.emitEvent(new Event().setType("on"));
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
        on();
        /*if(!isOn) {
            throw new SensorException("Sensor is not started");
        }*/
        generator.start();
        executorService.submit(() -> {
            while (isOn) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                Double value = generator.getValue();
                this.emitEvent(new Event().setType(Thread.currentThread().getName() + " Update " + this.id + " time: " + new Date() + "\n" +
                        "Class " + this.getClass()));
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
        out.write(msg.getBytes(StandardCharsets.UTF_8));
        out.flush();

    }

    public T getCurrentMeasure() {
        return this.measure;
    }

}
