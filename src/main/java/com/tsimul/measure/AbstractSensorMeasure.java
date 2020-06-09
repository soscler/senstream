package com.tsimul.measure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.device.sensor.Sensor;
import com.tsimul.util.Util;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * TODO: Measure should change
 * @param <T>
 */
@Getter
@Setter
public abstract class AbstractSensorMeasure<T> implements SensorMeasure<T> {

    private final Instant date = Instant.now();
    private final T value;
    @JsonIgnore
    private final Sensor<DeviceMetadata, T> sensor;

    protected AbstractSensorMeasure(T value, Sensor<DeviceMetadata, T> sensor) {
        this.sensor = sensor;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\nValue: " + value + "\nMessage: ";
    }

    @Override
    public String toJson() {
        try {
            return Util.jsonMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) { // Should never happen
            e.printStackTrace();
            return null;
        }
    }

}
