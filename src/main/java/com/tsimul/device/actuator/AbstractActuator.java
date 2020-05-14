package com.tsimul.device.actuator;

import com.tsimul.device.AbstractDevice;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.exception.DeviceException;

public abstract class AbstractActuator extends AbstractDevice<DeviceMetadata> implements Actuator {


    public AbstractActuator(DeviceMetadata metadata) {
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
