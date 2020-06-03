package com.tsimul.helpers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tsimul.measure.Measure;
import com.tsimul.plugin.transport.HTTPTransporter;
import com.tsimul.plugin.transport.TransporterMetadata;

@Singleton
public class ResourceModule {

    private final WebHelper webHelper;
    private final PluginHelper pluginHelper;
    private final HTTPTransporter<Measure> httpTransporter;

    @Inject
    public ResourceModule(WebHelper webHelper, PluginHelper pluginHelper, HTTPTransporter<Measure> httpTransporter) {
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

    public HTTPTransporter<Measure> getHttpTransporter() {
        return httpTransporter;
    }
}
