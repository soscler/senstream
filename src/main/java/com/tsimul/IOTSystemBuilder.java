package com.tsimul;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.tsimul.configuration.Config;
import com.tsimul.configuration.ConfigDetail;
import com.tsimul.device.sensor.Sensors;
import com.tsimul.exception.ConfigurationException;

import static com.tsimul.util.Util.isValidConfiguration;

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
    public IOTSystem build() throws ConfigurationException {

        if (! isValidConfiguration(config.getConfigJson())) {
            throw new ConfigurationException("Invalid Json. Please refer to the schema version");
        }
        Gson gson = new Gson();
        ConfigDetail configDetail = gson.fromJson(config.getConfigJson(), ConfigDetail.class);

        // TODO: Use DI and IOTSystem as a @Singleton
        ((AbstractIOTSystem)iotSystem).setName(configDetail.getName());
        configDetail.getSensors().forEach(s -> {
            switch (s.getGeneration().getType()) {
                case NUMERICAL:
                    iotSystem.register(Sensors.defaultSensor(
                            s.getMetadata(),
                            s.getGeneration().getMin(),
                            s.getGeneration().getMax(),
                            (long) s.getGeneration().getFrequency()));
                    break;
                case BOOLEAN:
                    System.out.println();
                    throw new UnsupportedOperationException();
                default:
                    break;

            }
        });
        iotSystem.subscribeToObservable(((AbstractIOTSystem)iotSystem).getSensors());

        return iotSystem;
    }

}
