package com.tsimul.plugin.transport;

import com.tsimul.measure.Measure;
import com.tsimul.plugin.AbstractPlugin;

/**
 * HTTP Transport helper
 */
public class HTTPTransporter<T extends Measure> extends AbstractPlugin implements Transporter<T> {



    @Override
    public void send(T data) {
    }
}
