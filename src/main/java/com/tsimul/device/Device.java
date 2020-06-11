package com.tsimul.device;

import com.tsimul.base.Thing;
import com.tsimul.event.Event;
import com.tsimul.event.Observable;
import com.tsimul.event.Observer;
import com.tsimul.event.data.EventData;
import com.tsimul.exception.DeviceException;

public interface Device<M extends DeviceMetadata> extends Observable, Observer, Thing<M> {

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

}
