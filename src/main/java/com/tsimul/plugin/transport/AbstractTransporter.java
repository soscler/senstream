package com.tsimul.plugin.transport;

import com.tsimul.plugin.AbstractPlugin;
import com.tsimul.util.Metadata;

public abstract class AbstractTransporter<T, M extends TransporterMetadata> extends AbstractPlugin<M> implements Transporter<T>  {

    // TransportHelper helper;

    TransporterConfig config;


    AbstractTransporter(M metadata /** TransportHelper helper */) {
        super(metadata);
        /**
         * this.helper = helper;
         */
    }
}
