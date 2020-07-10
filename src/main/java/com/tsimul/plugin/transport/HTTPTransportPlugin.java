package com.tsimul.plugin.transport;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tsimul.event.Event;
import com.tsimul.helpers.WebHelper;
import io.javalin.http.Context;
import io.javalin.http.sse.SseClient;
import io.javalin.websocket.WsHandler;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/**
 * HTTP Transport helper
 */
@Singleton
public class HTTPTransportPlugin extends AbstractTransportPlugin<TransporterMetadata> {

    private final WebHelper webHelper;

    @Inject
    HTTPTransportPlugin(@NotNull WebHelper webHelper, TransporterMetadata metadata) {
        super(metadata);
        this.webHelper = webHelper;
        //super.metadata.setType(ConfigDetail.PluginType.TRANSPORT);
        //super.metadata.setSubType(ConfigDetail.TransportType.HTTP);
    }

    /**
     * HTTP
     */
    public void get(String path) {

        webHelper.get(path, ctx -> {
            /**
             * Deux méthodes se présentent
             * (1) Utiliser un système d'information
             *      Cela implique a système d'avoir une liste de type d'information
             * (2) Utiliser l'api du système: Ajouter une interface au système pour donner juste acces a cet api
             * */
            // system.get(new Event(GET_INFO of Device with ID PATH)).subscribe(data -> {
            //      ctx.json(data);
            // };
            //ctx.json();
        });
    }

    /**
     * Websocket (WS)
     */
    public WsHandler ws(String path) {
        AtomicReference<WsHandler> wsHandler = new AtomicReference<>();
        webHelper.ws(path, handler -> {
            handler.onConnect(ctx -> {
                System.out.println("A user connected to this websocket");
            });
            handler.onMessage(ctx -> {
                // Process the message
                System.out.println(ctx.message());
                ctx.send("This is a response to the request");
            });
            handler.onClose(ctx -> {
            });

            handler.onError(ctx -> {
            });
            wsHandler.set(handler);
        });
        return wsHandler.get();
    }

    /**
     * Server Sent Event (SSE)
     */
    public SseClient sse(String path) {
        AtomicReference<SseClient> client = new AtomicReference<>();
        webHelper.sse(path, client::set);
        return client.get();
    }



    @Override
    public void processEvent(Event e) {

        System.out.println("\033[0;35m");
        System.out.println("Received event at the plugin HTTPTransporter level: " + e.getType());
        System.out.println(e);
        System.out.println(e.getData());
        System.out.println("\033[0m");


        /**
         * TODO: Enable path to name *
         * if(this.path == id) then Do next
         * else path = name ?
         */
       /* webHelper.get(e.getFrom().getId().toString() , context -> {

        });*/

        /**
         * TODO: Provide a method to to fetch the data from a specific device through the system
         */
       /* webHelper.get("/:id", ctx -> {

        });*/

        //webHelper.ws("/ws", wsHandlerConsumer2(e));

        /** TODO: enable path to name */
        try {
            webHelper.get(e.getFrom().getName() , ctx -> {
                ctx.json(e.getData());
            });
            System.out.println("After sending to get");
        } catch (Exception e1) {
            System.out.println(e1);
        }


        /*webHelper.sse(e.getFrom().getName(), sseClient -> {
            sseClient.sendEvent("data", e.toString());
        });*/
    }

    Consumer<WsHandler> wsHandlerConsumer2(Event e) {
        return new Consumer<WsHandler>() {
            @Override
            public void accept(WsHandler wsHandler) {
                    wsHandler.onConnect(ctx -> {
                        System.out.println("A user connected to this websocket");
                    });
                    wsHandler.onMessage(ctx -> {
                        System.out.println(ctx.message());
                        ctx.send("This is a response to the request " + e.getData());
                    });
                    wsHandler.onClose(ctx -> {

                    });

                    wsHandler.onError(ctx -> {
                    });
        }
        };
    }




}
