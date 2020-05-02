package com.tsimul.plugin.transport;

import com.tsimul.measure.Measure;

/**
 * Web Socket transport helper
 */
public class WSTransporter <T extends Measure> extends AbstractTransporter<T> {

    WSTransporter() {
        super();
        super.metadata.setType("ws");
    }

    @Override
    public void send(T data) {

    }
}
