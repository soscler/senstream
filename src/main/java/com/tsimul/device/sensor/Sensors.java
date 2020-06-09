package com.tsimul.device.sensor;

import com.google.common.primitives.Doubles;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.generator.Generators;

public class Sensors {

    private Sensors() {}

    public static DoubleSensor doubleSensor(DeviceMetadata metadata, double min, double max, long millis) {
        return new DoubleSensor(metadata, min, max, millis);
    }

    public static class DoubleSensor extends AbstractSensor<DeviceMetadata, Double> {

        DoubleSensor(DeviceMetadata metadata, double min, double max, long millis) {
            super(metadata, Generators.doubleRandomFrequencyGenerator(millis, min, max));
        }
    }
}
