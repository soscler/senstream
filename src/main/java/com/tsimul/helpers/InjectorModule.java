package com.tsimul.helpers;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.tsimul.IOTSystem;
import com.tsimul.IOTSystemImpl;
import io.javalin.Javalin;

/**
 * Configure Dependency injection
 */
public class InjectorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IOTSystem.class).to(IOTSystemImpl.class);
    }

    /**
     * TODO: Remove this resource from the dependency injection
     * @return
     */
    @Provides @Singleton
    Javalin webAppProvider() {
        Javalin app = Javalin.create();
        app.start(3000);
        return app;
    }

}
