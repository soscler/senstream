package com.tsimul.device.sensor;

import com.tsimul.device.DeviceMetadata;
import com.tsimul.generator.FrequencyGenerator;
import com.tsimul.measure.WeatherAbstractMeasure;

public class WeatherSensor extends AbstractSensor<WeatherAbstractMeasure, DeviceMetadata> {


    public WeatherSensor(DeviceMetadata metadata, double min, double max, long freq) {
        super(metadata, min, max, freq);
        WeatherAbstractMeasure measure = new WeatherAbstractMeasure(this);
        this.setMeasure(measure);
    }

    public WeatherSensor(DeviceMetadata metadata, FrequencyGenerator<Double> generator) {
        super(metadata, generator);
        WeatherAbstractMeasure measure = new WeatherAbstractMeasure(this);
        this.setMeasure(measure);
    }

}
