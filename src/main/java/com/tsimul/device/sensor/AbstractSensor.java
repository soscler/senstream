package com.tsimul.device.sensor;


import com.tsimul.device.AbstractDevice;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.event.Event;
import com.tsimul.exception.SensorException;
import com.tsimul.generator.FrequencyGenerator;
import com.tsimul.measure.Measures;
import com.tsimul.measure.SensorMeasure;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public abstract class AbstractSensor<M extends DeviceMetadata, T> extends AbstractDevice<M> implements Sensor<M, T> {

    private boolean isOn = false;
    private long frequency;
    private T currentValue;

    private final FrequencyGenerator<T> generator;
    private OutputStream out = System.out;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    AbstractSensor(M metadata, FrequencyGenerator<T> generator) {
        super(metadata);
        this.generator = generator;
        this.frequency = generator.getFrequency();
    }

    @Override
    public void on() {
        this.isOn = true;
        Event event = new Event(Event.EventType.ON, getMetadata(), null);
        this.emitEvent(event);
        generator.start();
        executorService.submit(() -> {
            while (isOn) {
                try {
                    Thread.sleep(Duration.ofSeconds(this.frequency).toMillis());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                currentValue = generator.getValue();
                Event e = new Event(Event.EventType.UPDATE, getMetadata(), getCurrentMeasure());
                this.emitEvent(e);
            }
        });
    }

    @Override
    public void off() {
        this.isOn = false;
        this.currentValue = null ;
        generator.stop();
        this.executorService.shutdownNow();
    }

    @Override
    public void start() throws SensorException {
        if(isOn) {
            throw new SensorException("Sensor is already started");
        }
        on();
    }

    @Override
    public void display() throws SensorException, IOException {
        String msg;
        if (! isOn ) throw new SensorException("Sensor is not started");
        if(getCurrentMeasure() == null) {
            msg = "Sensor: " + getName() + "No data to show, please make sure the sensor is working\n";
        }
        else msg = "Sensor: " + getName() + "\n" + getCurrentMeasure().toJson() + "\n";
        System.out.println("----------------------------------" + toJson());
        out.write(msg.getBytes(StandardCharsets.UTF_8));
        out.flush();

    }

    @Override
    public SensorMeasure<T> getCurrentMeasure() {
        return Measures.genericSensorMeasure(currentValue, this);
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

}
