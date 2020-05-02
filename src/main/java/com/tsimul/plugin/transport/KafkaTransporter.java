package com.tsimul.plugin.transport;

import com.tsimul.measure.Measure;

/**
 * Kafka transport helper
 * @version 1.0.0
 * For future a release, we will see this class as a sub class of MessagingTransporter
 * @param <T>
 */
public class KafkaTransporter<T extends Measure> extends AbstractTransporter<T> {

    KafkaTransporter() {
        super();
        super.metadata.setType("kafka");
    }

    @Override
    public void send(T data) {
        throw new UnsupportedOperationException();
    }
}
