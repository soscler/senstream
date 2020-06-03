package com.tsimul;

import com.google.inject.Inject;
import com.tsimul.helpers.ResourceModule;
import io.javalin.Javalin;

public class IOTSystemImpl extends AbstractIOTSystem {

    /**
     * This constructor is used to get a default iot system
     * @param app represents the web server resources
     */
    @Inject
    public IOTSystemImpl(ResourceModule resourceModule) {
        super(resourceModule);
    }
}
