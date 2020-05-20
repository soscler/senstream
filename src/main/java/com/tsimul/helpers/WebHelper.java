package com.tsimul.helpers;

import com.google.inject.Inject;
import io.javalin.Javalin;
import io.javalin.core.security.AccessManager;
import io.javalin.core.security.Role;
import io.javalin.http.Handler;
import io.javalin.websocket.WsHandler;
import io.javalin.websocket.WsHandlerType;
import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * This class can be seen as a proxy that helps plugins to use the under layer web resource of the system
 */
@Singleton
public class WebHelper {

    private final Javalin app;

    @Inject
    public WebHelper(Javalin app) {
        this.app = app;
    }

    public Javalin get(@NotNull String path, @NotNull Handler handler) {
        return app.get(path, handler);
    }

    public Javalin get(@NotNull String path, @NotNull Handler handler, @NotNull Set< Role > permittedRoles) {
        return app.get(path, handler, permittedRoles);
    }

    public Javalin put(@NotNull String path, @NotNull Handler handler) {
        return app.put(path, handler);
    }

    public Javalin put(@NotNull String path, @NotNull Handler handler, @NotNull Set< Role > permittedRoles) {
        return app.put(path, handler, permittedRoles);
    }

    public Javalin post(@NotNull String path, @NotNull Handler handler) {
        return app.post(path, handler);
    }

    public Javalin post(@NotNull String path, @NotNull Handler handler, @NotNull Set< Role > permittedRoles) {
        return app.post(path, handler, permittedRoles);
    }

    public Javalin delete(@NotNull String path, @NotNull Handler handler) {
        return app.delete(path, handler);
    }

    public Javalin delete(@NotNull String path, @NotNull Handler handler, @NotNull Set< Role > permittedRoles) {
        return app.delete(path, handler, permittedRoles);
    }

    public Javalin ws(@NotNull String path, @NotNull Consumer<WsHandler> ws) {
        return app.ws(path, ws);
    }

    public Javalin ws(@NotNull String path, @NotNull Consumer<WsHandler> ws, @NotNull Set<Role> permittedRoles) {
        return app.ws(path, ws, permittedRoles);
    }

}
