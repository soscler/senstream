package com.tsimul.device.sensor;

import com.tsimul.device.DeviceMetadata;

public class Sensors {

    private Sensors() {}

    public static Sensor defaultSensor(DeviceMetadata metadata, double min, double max, long frequency) {
        return new SensorImpl(metadata, min, max, frequency);
    }
}
