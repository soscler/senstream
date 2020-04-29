package com.tsimul.measure;

import com.tsimul.device.sensor.Sensor;

import java.io.Serializable;

public class WeatherAbstractMeasure extends AbstractMeasure<WeatherAbstractMeasure> implements Serializable, Measure {

    public static final long serialVersionUID = 1234L;

    public WeatherAbstractMeasure(Sensor<WeatherAbstractMeasure> sensor) {
        super(sensor);
    }
}
