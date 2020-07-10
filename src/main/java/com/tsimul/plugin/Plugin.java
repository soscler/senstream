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
 */
public interface Plugin extends Observable, Observer, Thing<PluginMetadata> {
}
