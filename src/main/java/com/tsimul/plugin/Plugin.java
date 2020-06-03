package com.tsimul.plugin;

import com.tsimul.device.Device;
import com.tsimul.event.Observable;
import com.tsimul.event.Observer;

/**
 *
 * A functionality that can be added to the system
 * Any plugin should therefore implement this interface
 * Requirements:
 * @param <M>
 */
public interface Plugin<M extends PluginMetadata> extends Observer, Observable {
    default String toJson() {
        throw new UnsupportedOperationException("This plugin does not support this method yet");
    }

    /**
     * TODO: Create two kinds of plugins
     * The ones that needs Administrative access, thus can control the whole system
     * The ones that does not need Administrative access, thus cannot control the whole system
     * @param d the device to be processed by this plugin
     */
    default void process(Device d) {
        throw new UnsupportedOperationException("This plugin does not support this method yet");
    }

    /**
     * Any method that implement this method, should provide a copy of the plugin metadata object instead of the original object
     * @return a copy of the plugin metadata
     */
    default M getMetadata() {
        throw new UnsupportedOperationException("This plugin does not support this method yet");
    }
}
