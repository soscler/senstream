package com.tsimul.helpers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tsimul.plugin.transport.HTTPTransportPlugin;

@Singleton
public class PluginHelperModule {

    private final WebHelper webHelper;
    private final PluginHelper pluginHelper;
    private final HTTPTransportPlugin httpTransporter;

    // TODO: store the plugins in a hashmap so that fetching a plugin by its name become easier

    

    @Inject
    public PluginHelperModule(WebHelper webHelper, PluginHelper pluginHelper, HTTPTransportPlugin httpTransporter) {
        this.webHelper = webHelper;
        this.pluginHelper = pluginHelper;
        this.httpTransporter = httpTransporter;
    }

    public WebHelper webHelper() {
        return this.webHelper;
    }

    public PluginHelper pluginHelper() {
        return this.pluginHelper;
    }

    public HTTPTransportPlugin getHttpTransporter() {
        return httpTransporter;
    }
}
