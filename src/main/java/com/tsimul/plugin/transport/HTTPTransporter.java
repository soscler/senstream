package com.tsimul.plugin.transport;

import com.tsimul.device.Device;
import com.tsimul.measure.Measure;
import io.javalin.Javalin;

/**
 * HTTP Transport helper
 */
public class HTTPTransporter<T extends Measure> extends AbstractTransporter<T> {

    private final Javalin app;

    HTTPTransporter() {
        app = Javalin.create();
    }

    HTTPTransporter(Javalin app) {
        super();
        this.app = app;
        super.metadata.setType("http");
    }

    @Override
    public void send(T data) {

    }

    @Override
    public void process(Device d) {

    }
}
