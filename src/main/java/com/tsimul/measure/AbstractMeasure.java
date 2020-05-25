package com.tsimul.measure;

import com.google.gson.Gson;
import com.tsimul.device.sensor.Sensor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class AbstractMeasure<T extends Measure> implements Measure {

    private final Instant date = Instant.now();
    private Double value;
    private String message;
    private final Sensor<T> sensor;

    protected AbstractMeasure(Sensor<T> sensor) {
        this.sensor = sensor;
    }

    @Override
    public void resolve(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\nValue: " + value + "\nMessage: " + message;
    }

    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}
