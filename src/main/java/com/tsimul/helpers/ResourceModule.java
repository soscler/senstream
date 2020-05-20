package com.tsimul.helpers;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.tsimul.IOTSystem;
import com.tsimul.IOTSystemBuilder;
import com.tsimul.IOTSystemImpl;
import io.javalin.Javalin;

public class ResourceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IOTSystem.class).to(IOTSystemImpl.class);
    }

    @Provides @Singleton
    Javalin webAppProvider() {
        return Javalin.create();
    }

}
