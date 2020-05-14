package com.tsimul.device.sensor;

import com.tsimul.device.DeviceMetadata;
import com.tsimul.generator.FrequencyGenerator;

public class Sensors {

    private Sensors() {}

    public static WeatherSensor weatherSensor(DeviceMetadata metadata, FrequencyGenerator<Double> generator) {
        return new WeatherSensor(metadata, generator);
    }

    public static WeatherSensor weatherSensor(DeviceMetadata metadata, double min, double max, long frequency) {
        return new WeatherSensor(metadata, min, max, frequency);
    }

    public static Sensor defaultSensor(DeviceMetadata metadata, double min, double max, long frequency) {
        return new SensorImpl(metadata, min, max, frequency);
    }
}
