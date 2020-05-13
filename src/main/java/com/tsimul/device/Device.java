package com.tsimul.device;

import com.tsimul.event.Observable;
import com.tsimul.event.Observer;
import com.tsimul.exception.DeviceException;

public interface Device extends Observable, Observer {

    /**
     * Turn on the sensor
     * @throws DeviceException
     */
    default void on() throws DeviceException {
        throw new UnsupportedOperationException("This device does not support this operation");
    }

    /**
     * Turn off the sensor
     * Set measure to null so that Java Garbage Collector can free the memory
     */
    default void off() throws DeviceException {
        throw new UnsupportedOperationException("This device does not support this operation");
    }

    /**
     * TODO: Should this function be here ?
     * @return
     */
    default String toJson() {
        throw new UnsupportedOperationException("This device does not support this method yet");
    }

}
