package com.tsimul.measure;

import com.tsimul.device.DeviceMetadata;
import com.tsimul.device.sensor.Sensor;

public class Measures {

    private Measures() {}

    public static DoubleSensorMeasureAbstract doubleSensorMeasure(Double value, Sensor<DeviceMetadata, Double> sensor) {
        return new DoubleSensorMeasureAbstract(value, sensor);
    }

    public static <T> GenericSensorMeasureAbstract genericSensorMeasure(T value, Sensor<? extends DeviceMetadata, T> sensor) {
        return new GenericSensorMeasureAbstract(value, sensor);
    }

    public static class DoubleSensorMeasureAbstract extends AbstractSensorMeasure<Double> {

        public DoubleSensorMeasureAbstract(Double value, Sensor<DeviceMetadata, Double> sensor) {
            super(value, sensor);
        }
    }

    public static class GenericSensorMeasureAbstract<T> extends AbstractSensorMeasure<T> {

        public GenericSensorMeasureAbstract(T value, Sensor<DeviceMetadata, T> sensor) {
            super(value, sensor);
        }
    }
}
