package com.tsimul.measure;

import com.tsimul.device.sensor.Sensor;

import java.io.Serializable;

public class MeasureImpl extends AbstractMeasure<MeasureImpl> implements Serializable, Measure {

    public static final long serialVersionUID = 1234L;

    public MeasureImpl(Sensor<MeasureImpl> sensor) {
        super(sensor);
    }
}
