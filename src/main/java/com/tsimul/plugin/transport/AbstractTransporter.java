package com.tsimul.plugin.transport;

import com.tsimul.plugin.AbstractPlugin;

public abstract class AbstractTransporter<T> extends AbstractPlugin<TransporterMetadata> implements Transporter<T>  {

    // TransportHelper helper;

    TransporterConfig config;


    AbstractTransporter(/** TransportHelper helper */) {
        /**
         * this.helper = helper;
         */
        this.metadata = new TransporterMetadata();
    }
}
