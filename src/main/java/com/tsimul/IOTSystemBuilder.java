package com.tsimul;

import com.google.gson.*;
import com.tsimul.configuration.Config;
import com.tsimul.device.sensor.Sensor;
import com.tsimul.device.sensor.Sensors;
import com.tsimul.exception.ConfigurationException;

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

    private Sensor resolveSensor(JsonElement sensorElt) {
        System.out.println(sensorElt);
        return null;
    }

    @Override
    public IOTSystem build() throws ConfigurationException {

        if (! isValidConfiguration(config.getConfigJson())) {
            throw new ConfigurationException("Invalid Json. Please refer to the schema version");
        }
        JsonElement root = JsonParser.parseString(config.getConfigJson());
        IOTSystemImpl iotSystem = new IOTSystemImpl();
        iotSystem.setName(root.getAsJsonObject().get("name").getAsString());
        System.out.println(root.getAsJsonObject().getAsJsonPrimitive("description"));

        JsonElement sensorsArray = root.getAsJsonObject().get("sensors");
        if(sensorsArray != null) {
            JsonArray sensors = sensorsArray.getAsJsonArray();
            sensors.forEach(this::resolveSensor);
        }
        return iotSystem;
    }
}
