package com.tsimul.plugin.transport;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tsimul.configuration.ConfigDetail;
import com.tsimul.device.Device;
import com.tsimul.event.Event;
import com.tsimul.helpers.WebHelper;
import com.tsimul.measure.Measure;
import io.javalin.Javalin;

/**
 * HTTP Transport helper
 */
@Singleton
public class HTTPTransporter<T extends Measure> extends AbstractTransporter <T, TransporterMetadata> {

    private final WebHelper webHelper;

    @Inject
    HTTPTransporter(WebHelper webHelper, TransporterMetadata metadata) {
        super(metadata);
        this.webHelper = webHelper;
        //super.metadata.setType(ConfigDetail.PluginType.TRANSPORT);
        //super.metadata.setSubType(ConfigDetail.TransportType.HTTP);
    }

    @Override
    public void send(T data) {

    }

    @Override
    public void process(Device d) {

    }

    @Override
    public void processEvent() {

    }

    @Override
    public void processEvent(Event e) {
        System.out.println("\033[0;31m");
        System.out.println("*************************************** Event in " + this.getClass().getName());
        System.out.println(e.from().getId());
        System.out.println("\033[0m");
        /**
         * TODO: Enable path to name *
         * if(this.path == id) then Do next
         * else path = name ?
         */
        webHelper.get(e.from().getId().toString() , context -> {
            context.json(e);
        });

        /**
         * TODO: Provide a method to to fetch the data from a specific device through the system
         */
        webHelper.get("/:id", ctx -> {
            ctx.json(e);
        });

        /** TODO: enable path to name */
        webHelper.get(e.from().getName() , context -> {
            context.json(e);
        });

    }
}
