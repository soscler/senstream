package com.tsimul.device.actuator;

import com.tsimul.device.AbstractDevice;
import com.tsimul.device.Device;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.exception.DeviceException;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractActuator<M extends DeviceMetadata> extends AbstractDevice<M> {

    private final Device<M> target;

    public AbstractActuator(M metadata, @NotNull final Device<M> target) {
        super(metadata);
        this.target = target;
    }

    @Override
    public void on() throws DeviceException {
        target.on();
        //throw new UnsupportedOperationException("This actuator does not support this operation");
    }

    @Override
    public void off() throws DeviceException {
        target.off();
        //throw new UnsupportedOperationException("This actuator does not support this operation");
    }
}
