package com.tsimul;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.tsimul.configuration.Config;
import com.tsimul.configuration.ConfigDetail;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.device.sensor.Sensor;
import com.tsimul.device.sensor.Sensors;
import com.tsimul.exception.ConfigurationException;

import static com.tsimul.util.Util.*;

public class IOTSystemBuilder extends AbstractIOTSystemBuilder {

    private Config config;
    private final IOTSystem iotSystem;

    /**
     * TODO: Add a default config and make this constructor public
     * @param iotSystem
     */
    @Inject
    private IOTSystemBuilder(IOTSystem iotSystem){
        this.iotSystem = iotSystem;
    }

    public IOTSystemBuilder config(Config config) {
        this.config = config;
        return this;
    }

    //TODO: Find a way to make the constructor stateless ?

    @Override
    public IOTSystem build() throws ConfigurationException, JsonProcessingException {

        if (! isValidConfiguration(config.getConfigJson())) {
            throw new ConfigurationException("Invalid Json. Please refer to the schema version");
        }
        ObjectMapper mapper = new ObjectMapper();
        ConfigDetail configDetail = mapper.readValue(config.getConfigJson(), ConfigDetail.class);
        // Save the initial configuration in the cache
        cache.put(CONFIG_JSON_DATA_KEY, configDetail);

        // TODO: Use DI and IOTSystem as a @Singleton
        iotSystem.setName(configDetail.getName());
        iotSystem.setDescription(configDetail.getDescription());

        configDetail.getSensors().forEach(s -> {
            switch (s.getGeneration().getType()) {
                case NUMERICAL:
                    Sensor<DeviceMetadata, Double> sensor = Sensors.doubleSensor(
                            s.getMetadata(),
                            s.getGeneration().getMin(),
                            s.getGeneration().getMax(),
                            (long) s.getGeneration().getFrequency());
                    iotSystem.register(sensor);
                    break;
                case BOOLEAN:
                    throw new UnsupportedOperationException();
                default:
                    break;
            }
            configDetail.getPlugins().forEach(p -> {
                System.out.println("\033[0;31m");
                p.getSubscribe().getAllEvents().getEventTypes().forEach(System.out::println);
                System.out.println("\033[0m");

                switch (s.getTransport()) {
                    case HTTP:

                        // Set up metadata
                        iotSystem.getResourceModule()
                                .getHttpTransporter()
                                .getMetadata()
                                .setSubscriptionDetail(p.getSubscribe());

                        iotSystem.getResourceModule()
                                .pluginHelper()
                                .setupPlugin(
                                        iotSystem.getResourceModule()
                                        .getHttpTransporter()
                                );

                }
            });
        });
        /**
         * TODO: Should the system delegate the subscription to the PluginHelper/EventHelper or should we keep it like that ?
         */
        iotSystem.subscribeToObservable(iotSystem.getDevices());
        return iotSystem;
    }
}
