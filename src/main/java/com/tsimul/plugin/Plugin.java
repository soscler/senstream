package com.tsimul.plugin;

import com.tsimul.base.Thing;
import com.tsimul.device.Device;
import com.tsimul.event.Observable;
import com.tsimul.event.Observer;

/**
 *
 * A functionality that can be added to the system
 * Any plugin should therefore implement this interface
 * Requirements:
 * @param <T>
 */
public interface Plugin<T extends PluginMetadata> extends Observable, Observer, Thing<T> {
}
