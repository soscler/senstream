package com.tsimul.device.actuator;

import com.tsimul.device.AbstractDevice;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.exception.DeviceException;

public abstract class AbstractActuator<M extends DeviceMetadata> extends AbstractDevice<M> {


    public AbstractActuator(M metadata) {
        super(metadata);
    }

    @Override
    public void on() throws DeviceException {
        throw new UnsupportedOperationException("This actuator does not support this operation");
    }

    @Override
    public void off() throws DeviceException {
        throw new UnsupportedOperationException("This actuator does not support this operation");
    }
}
