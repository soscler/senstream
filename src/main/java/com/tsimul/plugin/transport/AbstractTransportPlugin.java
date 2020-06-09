package com.tsimul.plugin.transport;

import com.tsimul.plugin.AbstractPlugin;

public abstract class AbstractTransportPlugin<M extends TransporterMetadata> extends AbstractPlugin<M> implements TransportPlugin<M> {

    // TransportHelper helper;

    TransporterConfig config;


    AbstractTransportPlugin(M metadata /** TransportHelper helper */) {
        super(metadata);
        /**
         * this.helper = helper;
         */
    }
}
