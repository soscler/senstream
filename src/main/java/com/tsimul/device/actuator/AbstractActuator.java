package com.tsimul.device.actuator;

import com.tsimul.device.AbstractDevice;
import com.tsimul.exception.DeviceException;

public abstract class AbstractActuator extends AbstractDevice implements Actuator {


    @Override
    public void on() throws DeviceException {
        throw new UnsupportedOperationException("This actuator does not support this operation");
    }

    @Override
    public void off() throws DeviceException {
        throw new UnsupportedOperationException("This actuator does not support this operation");
    }
}
