package com.tsimul.plugin.transport;

import com.tsimul.plugin.Plugin;
import com.tsimul.plugin.PluginMetadata;

public interface TransportPlugin<T extends TransporterMetadata> extends Plugin<T> {
}
