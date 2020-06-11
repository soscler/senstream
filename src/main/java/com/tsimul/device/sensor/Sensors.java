package com.tsimul.device.sensor;

import com.google.common.primitives.Doubles;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.generator.Generators;

public class Sensors {

    private Sensors() {}

    public static DoubleSensor doubleSensor(DeviceMetadata metadata, double min, double max, long secs) {
        return new DoubleSensor(metadata, min, max, secs);
    }

    public static class DoubleSensor extends AbstractSensor<DeviceMetadata, Double> {

        DoubleSensor(DeviceMetadata metadata, double min, double max, long secs) {
            super(metadata, Generators.doubleRandomFrequencyGenerator(min, max, secs));
        }
    }
}
