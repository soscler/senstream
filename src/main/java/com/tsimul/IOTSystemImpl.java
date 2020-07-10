package com.tsimul;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tsimul.base.Metadata;
import com.tsimul.helpers.PluginHelperModule;

@Singleton
public class IOTSystemImpl extends AbstractIOTSystem {

    /**
     * This constructor is used to get a default iot system
     * @param app represents the web server resources
     */
    @Inject
    public IOTSystemImpl(PluginHelperModule pluginHelperModule) {
        super(pluginHelperModule);
    }

    @Override
    public Metadata getMetadata() {
        return null;
    }

    @Override
    public void update() {

    }
}
