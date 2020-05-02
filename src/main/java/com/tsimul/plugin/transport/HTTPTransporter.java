package com.tsimul.plugin.transport;

import com.tsimul.device.Device;
import com.tsimul.measure.Measure;
import com.tsimul.plugin.AbstractPlugin;

/**
 * HTTP Transport helper
 */
public class HTTPTransporter<T extends Measure> extends AbstractTransporter<T> {


    HTTPTransporter() {
        super();
        super.metadata.setType("http");
    }

    @Override
    public void send(T data) {
    }

    @Override
    public void process(Device d) {

    }
}
