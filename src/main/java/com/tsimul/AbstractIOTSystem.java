package com.tsimul;

import com.google.gson.Gson;
import com.tsimul.device.Device;
import com.tsimul.device.sensor.Sensor;
import com.tsimul.exception.DeviceException;
import com.tsimul.exception.SensorException;
import com.tsimul.measure.Measure;
import com.tsimul.plugin.Plugin;
import com.tsimul.util.Metadata;
import io.javalin.Javalin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractIOTSystem implements IOTSystem {

    /**
     * TODO: Create a class to store the metadata ?
     */
    private Metadata metadata;

    private final Javalin app = Javalin.create();

    // TODO: Make sure to use the right collection
    // Since there is a unique identifier for each sensor, use a hash map instead ?
    ArrayList<Sensor<? extends Measure>> sensors = new ArrayList<>();
    ArrayList<Device> devices = new ArrayList<>();
    ArrayList<Plugin> plugins = new ArrayList<>();

    @Override
    public void start() {
        sensors.forEach(sensor -> {
            try {
                sensor.start();
            }  catch (SensorException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    @Override
    public void stop() {
        sensors.forEach(s -> {
            try {
                s.off();
            } catch (DeviceException e) {
                e.printStackTrace();
            }
        });
    }

    public void display() {
        sensors.forEach(sensor -> {
            try {
                sensor.display();
            } catch (SensorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });
    }


    public void register(Sensor<? extends Measure> sensor) {
        sensors.add(sensor);
    }

    /**
     * TODO Make sure the remove works, so make sure the equals fonction of Sensor works fine
     * @param sensor
     */
    public void deregister(Sensor<? extends Measure> sensor) {
        sensors.remove(sensor);
    }

    public void startWebServer() {
        // Publish the system global information

        app.get("description", ctx -> {
            ctx.json(metadata);
        });

        // Publish the devices information

        // Publish the plugins information
    }

    public Javalin getWebServer() {
        return this.app;
    }

    public String toJson() {
        ArrayList<String> sensorsDetails = new ArrayList<>();
        ArrayList<String> devicesDetails = new ArrayList<>();
        ArrayList<String> pluginsDetails = new ArrayList<>();
        Map<String, Object> systemDetails = new HashMap<>();

        sensors.forEach(s -> {
            sensorsDetails.add(s.toJson());
        });

        plugins.forEach(p -> {
            pluginsDetails.add(p.toJson());
        });

        devices.forEach(d -> {
            devicesDetails.add(d.toJson());
        });

        systemDetails.put("devices", devicesDetails);
        systemDetails.put("plugins", pluginsDetails);

        Gson gson = new Gson();
        String metadata = gson.toJson(this.metadata);

        throw new UnsupportedOperationException("The system does not support this method yet");
    }
}
