package com.tsimul.plugin;

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
}
