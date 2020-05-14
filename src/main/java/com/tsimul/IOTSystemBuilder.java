package com.tsimul;

import com.google.gson.*;
import com.tsimul.configuration.Config;
import com.tsimul.configuration.ConfigDetail;
import com.tsimul.device.DeviceMetadata;
import com.tsimul.device.sensor.Sensors;
import com.tsimul.exception.ConfigurationException;

import java.util.concurrent.ThreadLocalRandom;

import static com.tsimul.util.Util.*;

public class IOTSystemBuilder extends AbstractIOTSystemBuilder {

    private Config config;

    /**
     * TODO: Add a default config and make this constructor public
     */
    private IOTSystemBuilder(){}

    public IOTSystemBuilder(Config config){
        this.config = config;
    }

    public IOTSystemBuilder config(Config config) {
        this.config = config;
        return this;
    }

    @Override
    public IOTSystem build() throws ConfigurationException {

        if (! isValidConfiguration(config.getConfigJson())) {
            throw new ConfigurationException("Invalid Json. Please refer to the schema version");
        }
        Gson gson = new Gson();
        ConfigDetail configDetail = gson.fromJson(config.getConfigJson(), ConfigDetail.class);

        IOTSystemImpl iotSystem = new IOTSystemImpl();
        iotSystem.setName(configDetail.getName());
        configDetail.getSensors().forEach(s -> {
            System.out.println(s.getMetadata().toString());
            if(s.getGeneration().getType() == ConfigDetail.GenerationType.NUMERICAL) {
                System.out.println(s.getGeneration().toString());
                iotSystem.register(Sensors.defaultSensor(
                        s.getMetadata(),
                        s.getGeneration().getMin(),
                        s.getGeneration().getMax(),
                        (long) s.getGeneration().getFrequency()));
            }
        });
        iotSystem.subscribeToObservable(iotSystem.getSensors());

        return iotSystem;
    }

}
