package com.tsimul.device.sensor;

import com.tsimul.generator.FrequencyGenerator;
import com.tsimul.measure.MeasureImpl;
import com.tsimul.measure.WeatherAbstractMeasure;

public class SensorIpml extends AbstractSensor<MeasureImpl> {

    public SensorIpml(long id, double min, double max, long freq) {
        super(id, min, max, freq);
        MeasureImpl measure = new MeasureImpl(this);
        this.setMeasure(measure);
    }

    public SensorIpml(long id, FrequencyGenerator<Double> generator) {
        super(id, generator);
        MeasureImpl measure = new MeasureImpl(this);
        this.setMeasure(measure);
    }
}
