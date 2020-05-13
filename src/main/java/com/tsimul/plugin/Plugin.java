package com.tsimul.plugin;

import com.tsimul.device.Device;
import com.tsimul.event.Observable;

/**
 *
 * A functionality that can be added to the system
 * Any plugin should therefore implement this interface
 * Requirements:
 */
public interface Plugin {
    default String toJson() {
        throw new UnsupportedOperationException("This plugin does not support this method yet");
    }

    /**
     * TODO: Create two kinds of plugins
     * The ones that needs Administrative access, thus can control the whole system
     * The ones that does not need Administrative access, thus cannot control the whole system
     * @param d
     */
    default void process(Device d) {
        throw new UnsupportedOperationException("This plugin does not support this method yet");
    };
}
