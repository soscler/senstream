package com.tsimul.device.sensor;

import com.tsimul.device.Device;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.exception.SensorException;
import com.tsimul.measure.SensorMeasure;

import java.io.IOException;

/**
 * TODO: Create a display interface so that a sensor can display its data to a generic display
 * Display can be STDOUT or whatever display that can handle the data
 */
public interface Sensor <M extends DeviceMetadata, T> extends Device<M> {

    /**
     * Start the measurement process. This will turn on the sensor
     * @throws InterruptedException
     * @throws SensorException
     */
    default void start() throws SensorException, InterruptedException {
        throw new UnsupportedOperationException("This sensor does not support this operation");
    }

    /**
     * Display the current measurement
     * @throws IOException
     * @throws SensorException
     */
    default void display() throws SensorException, IOException {
        throw new UnsupportedOperationException("This sensor does not support this operation");
    }

    /**
     *
     * @return the current/or last value of the sensor
     */
    default SensorMeasure<T> getCurrentMeasure() {
        throw new UnsupportedOperationException("This sensor does not support this operation");
    }
}
