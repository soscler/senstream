package com.tsimul.plugin;

import com.google.inject.Inject;
import com.tsimul.plugin.transport.HTTPTransportPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Plugins {

    private final HashMap<String, Plugin> plugins;

    @Inject
    private Plugins(final @NotNull HTTPTransportPlugin httpTransportPlugin) {
        plugins = new HashMap<>();
    }

    public void addPlugin(String key, Plugin p) {
        plugins.put(key, p);
    }

    // Building a plugin is expensive, and to keep things synchronized we avoid copying the plugin
    public Plugin getPlugin(String key) {
        return plugins.get(key);
    }
}
