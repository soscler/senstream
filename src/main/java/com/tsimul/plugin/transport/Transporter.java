package com.tsimul.plugin.transport;

import com.tsimul.plugin.Plugin;

public interface Transporter<T> extends Plugin {
    public void send(T data);
}
