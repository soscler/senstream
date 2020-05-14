package com.tsimul.device.sensor;


import com.tsimul.device.AbstractDevice;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.event.Event;
import com.tsimul.exception.SensorException;
import com.tsimul.generator.FrequencyGenerator;
import com.tsimul.generator.Generators;
import com.tsimul.measure.Measure;
import com.tsimul.measure.MeasureImpl;
import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public abstract class AbstractSensor<T extends Measure, M extends DeviceMetadata> extends AbstractDevice<M> implements Sensor<T> {

    private boolean isOn = false;
    private long millis;
    private FrequencyGenerator<Double> generator;
    private T measure;
    private OutputStream out = System.out;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    AbstractSensor(M metadata, double min, double max, long millis) {

        super(metadata);
        this.millis = millis;
        this.generator = Generators.doubleRandomFrequencyGenerator(millis, min, max);
    }

    AbstractSensor(M metadata, FrequencyGenerator<Double> generator) {
        super(metadata);
        this.generator = generator;
    }

    public AbstractSensor(M metadata) {
        super(metadata);
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
                    Thread.sleep(Duration.ofSeconds(this.millis).toMillis());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                Double value = generator.getValue();
                this.emitEvent(new Event().setType("update " + getName()+ " time: " + new Date()));
                measure.resolve(value);
            }
        });
    }

    @Override
    public void display() throws SensorException, IOException {
        String msg;
        if (! isOn ) throw new SensorException("Sensor is not started");
        if(measure == null) {
            msg = "Sensor: " + getName() + "No data to show, please make sure the sensor is working\n";
        }
        else msg = "Sensor: " + getName() + "\n" + measure.toJson() + "\n";
        out.write(msg.getBytes(StandardCharsets.UTF_8));
        out.flush();

    }

    public T getCurrentMeasure() {
        return this.measure;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public void setMeasure(T measure) {
        this.measure = measure;
    };
}
