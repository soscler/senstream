package com.tsimul.plugin.transport;

import com.tsimul.measure.SensorMeasure;

/**
 * Kafka transport helper
 * @version 1.0.0
 * For future a release, we will see this class as a sub class of MessagingTransporter
 * @param <T>
 */
public class KafkaTransportPlugin<T extends SensorMeasure> extends AbstractTransportPlugin<TransporterMetadata> {

    KafkaTransportPlugin() {
        super(null);
        //super.metadata.setType("kafka");
    }
/*
    @Override
    public void send(T data) {
        throw new UnsupportedOperationException();
    }*/
}
