package com.tsimul.plugin.transport;

import com.tsimul.device.Device;
import com.tsimul.event.Event;
import com.tsimul.measure.Measure;
import io.javalin.Javalin;

/**
 * HTTP Transport helper
 */
public class HTTPTransporter<T extends Measure> extends AbstractTransporter<T, TransporterMetadata> {

    private final Javalin app;

    HTTPTransporter() {
        super(null);
        app = Javalin.create();
    }

    HTTPTransporter(Javalin app) {
        super(null);
        this.app = app;
        super.metadata.setType("http");
    }

    @Override
    public void send(T data) {

    }

    @Override
    public void process(Device d) {

    }

    @Override
    public void processEvent() {

    }

    @Override
    public void processEvent(Event e) {
        System.out.println("\033[0;31m");
        System.out.println("Received event");
        System.out.println("\033[0m");

    }
}
