package com.tsimul.device.controller;

import com.tsimul.device.Device;
import com.tsimul.device.DeviceMetadata;

public interface Controller<M extends DeviceMetadata> extends Device<M> {
}
