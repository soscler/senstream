package com.tsimul.plugin.transport;

import com.tsimul.plugin.Plugin;
import com.tsimul.plugin.PluginMetadata;

public interface Transporter<T> extends Plugin {
    public void send(T data);

}
