package com.tsimul.device.sensor;

import com.tsimul.generator.FrequencyGenerator;
import com.tsimul.measure.WeatherAbstractMeasure;

public class WeatherSensor extends AbstractSensor<WeatherAbstractMeasure> {


    public WeatherSensor(long id, double min, double max, long freq) {
        super(id, min, max, freq);
        WeatherAbstractMeasure measure = new WeatherAbstractMeasure(this);
        this.setMeasure(measure);
    }

    public WeatherSensor(long id, FrequencyGenerator<Double> generator) {
        super(id, generator);
        WeatherAbstractMeasure measure = new WeatherAbstractMeasure(this);
        this.setMeasure(measure);
    }

}
