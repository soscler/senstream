package com.tsimul.device.sensor;

import com.tsimul.device.DeviceMetadata;
import com.tsimul.generator.FrequencyGenerator;
import com.tsimul.measure.MeasureImpl;
import com.tsimul.measure.WeatherAbstractMeasure;

public class SensorImpl extends AbstractSensor<MeasureImpl, DeviceMetadata> {

    public SensorImpl(DeviceMetadata metadata, double min, double max, long freq) {
        super(metadata, min, max, freq);
        MeasureImpl measure = new MeasureImpl(this);
        this.setMeasure(measure);
    }

    public SensorImpl(DeviceMetadata metadata, FrequencyGenerator<Double> generator) {
        super(metadata, generator);
        MeasureImpl measure = new MeasureImpl(this);
        this.setMeasure(measure);
    }
}
