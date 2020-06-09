package com.tsimul.plugin.transport;

import com.tsimul.measure.SensorMeasure;

/**
 * Web Socket transport helper
 */
public class WSTransportPlugin<T extends SensorMeasure> extends AbstractTransportPlugin<TransporterMetadata> {

    /**
     * TODO: create a Plugins class that will provide singleton default plugins
     */
    WSTransportPlugin() {
        super(null);
        //super.metadata.setType("ws");
    }

/*    @Override
    public void send(T data) {

    }*/
}
