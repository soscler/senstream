package com.tsimul.plugin;

import com.tsimul.IOTSystem;
import com.tsimul.Registry;
import com.tsimul.base.Metadata;
import com.tsimul.base.Thing;
import com.tsimul.device.Device;
import com.tsimul.event.Observable;
import com.tsimul.event.Observer;
import com.tsimul.measure.Measure;

/**
 *
 * A functionality that can be added to the system
 * Any plugin should therefore implement this interface
 * Requirements:
 */
public interface Plugin extends Observable, Observer, Thing<PluginMetadata> {
    void setSystem(final Registry<Measure<Double>> iotSystem);
}
