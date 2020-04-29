package com.tsimul.device.sensor;

import com.tsimul.generator.FrequencyGenerator;

public class Sensors {

    private Sensors() {}

    public static WeatherSensor weatherSensor(long id, FrequencyGenerator<Double> generator) {
        return new WeatherSensor(id, generator);
    }

    public static WeatherSensor weatherSensor(long id, double min, double max, long frequency) {
        return new WeatherSensor(id, min, max, frequency);
    }
}
