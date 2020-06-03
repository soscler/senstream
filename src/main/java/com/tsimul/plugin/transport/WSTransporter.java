package com.tsimul.plugin.transport;

import com.tsimul.measure.Measure;

/**
 * Web Socket transport helper
 */
public class WSTransporter <T extends Measure> extends AbstractTransporter<T, TransporterMetadata> {

    /**
     * TODO: create a Plugins class that will provide singleton default plugins
     */
    WSTransporter() {
        super(null);
        //super.metadata.setType("ws");
    }

    @Override
    public void send(T data) {

    }
}
