package com.tsimul.device.actuator;

import com.tsimul.device.Device;
import com.tsimul.device.DeviceMetadata;

/**
 * TODO: Add a Rule engine to enable automation between sensors and actuators
 * @param <M>
 */
public interface Actuator<M extends DeviceMetadata> extends Device<M> {
}
