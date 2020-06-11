package com.tsimul.plugin.transport;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tsimul.event.Event;
import com.tsimul.helpers.WebHelper;
import com.tsimul.measure.SensorMeasure;
import com.tsimul.util.Util;

/**
 * HTTP Transport helper
 */
@Singleton
public class HTTPTransportPlugin extends AbstractTransportPlugin<TransporterMetadata> {

    private final WebHelper webHelper;

    @Inject
    HTTPTransportPlugin(WebHelper webHelper, TransporterMetadata metadata) {
        super(metadata);
        this.webHelper = webHelper;
        //super.metadata.setType(ConfigDetail.PluginType.TRANSPORT);
        //super.metadata.setSubType(ConfigDetail.TransportType.HTTP);
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


        /** TODO: enable path to name */
        webHelper.get(e.getFrom().getName() , ctx -> {
            ctx.json((SensorMeasure) e.getData());
        });

    }

}
