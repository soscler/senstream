package com.tsimul.plugin.transport;

import com.tsimul.measure.Measure;

/**
 * Kafka transport helper
 * @param <T>
 */
public class KafkaAbstractTransporter<T extends Measure> extends AbstractTransporter<T> {

    @Override
    public void send(T data) {
        throw new UnsupportedOperationException();
    }
}
