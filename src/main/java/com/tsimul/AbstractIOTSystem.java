package com.tsimul;

import com.tsimul.device.Device;
import com.tsimul.device.sensor.Sensor;
import com.tsimul.event.*;
import com.tsimul.exception.DeviceException;
import com.tsimul.exception.SensorException;
import com.tsimul.helpers.ResourceModule;
import com.tsimul.measure.Measure;
import com.tsimul.plugin.Plugin;
import com.tsimul.base.Metadata;
import io.javalin.Javalin;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * TODO: Use webHelper for even the system
 * The best way to keep a secret, is to keep it a secret to yourself (is to ignore the secret)
 */
public abstract class AbstractIOTSystem implements IOTSystem {

    /**
     * TODO: Create a class to store the metadata ?
     */
    private final Metadata metadata;
    private final Observer observer;
    private final Observable observable;
    private final ResourceModule resourceModule;

    // TODO: Make sure to use the right collection
    // Since there is a unique identifier for each sensor, use a hash map or a Set instead ?
    private final List<Sensor<Measure>> sensors = new ArrayList<>();
    private final List<Device> devices = new ArrayList<>();
    private final List<Plugin> plugins = new ArrayList<>();

    AbstractIOTSystem(ResourceModule resourceModule) {
        super();
        this.metadata = new Metadata("DefaultName", "DefaultVersion", "DefaultDescription");
        this.observer = new ObserverImpl(this);
        this.observable = new ObservableImpl();
        this.resourceModule = resourceModule;
    }

    @Override
    public void start() {
        resourceModule.webHelper().get("/", context -> {
            context.json(this.metadata);
        });

        resourceModule.webHelper().ws("/ws", wsHandler -> {
            wsHandler.onConnect(wsConnectContext -> {
                System.out.println("Connected");
            });
            wsHandler.onMessage(wsMessageContext -> {
                wsMessageContext.send(this.metadata);
            });
        });
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
        System.out.println(metadata.toJson());
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


    public void register(Sensor<Measure> sensor) {
        sensors.add(sensor);
    }

    /**
     * TODO Make sure the remove works, so make sure the equals fonction of Sensor works fine
     * @param sensor
     */
    public void deregister(Sensor<Measure> sensor) {
        sensors.remove(sensor);
        unsubscribeFromObservable(sensor);
    }

    @Override
    public void processEvent() {
        System.out.println("\033[0;31m");
        System.out.println("Received event");
        System.out.println("\033[0m");
    }

    @Override
    public void processEvent(Event<? extends Metadata> e) {
        /*System.out.println("\033[0;36m");
        System.out.println("Received event: " + e.getType());
        System.out.println("\033[0m");*/

        this.resourceModule.pluginHelper().forwardEvent(e);
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observable.registerObserver(observer);
    }

    @Override
    public void registerObserver(List<? extends Observer> observers) {
        this.observable.registerObserver(observers);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observable.unregisterObserver(observer);
    }

    @Override
    public void unregisterObserver(List<? extends Observer> observers) {
        this.observable.unregisterObserver(observers);
    }

    @Override
    public void emitEvent() {
        this.observable.emitEvent();
    }

    @Override
    public void emitEvent(Event<? extends Metadata> event) {
        this.observable.emitEvent(event);
    }

    @Override
    public void subscribeToObservable(Observable observable) {
        this.observer.subscribeToObservable(observable);
    }

    @Override
    public void subscribeToObservable(List<? extends Observable> observables) {
        this.observer.subscribeToObservable(observables);
    }

    @Override
    public void unsubscribeFromObservable(Observable observable) {
        this.observer.unsubscribeFromObservable(observable);
    }

    @Override
    public void unsubscribeFromObservable(List<? extends Observable> observables) {
        this.observer.unsubscribeFromObservable(observables);

    }

    @Override
    public void plugin(Plugin p) {
        plugins.add(p);
        registerObserver(p);
        Event<Metadata> e = new Event<>(this.metadata);
        e.setType(Event.EventType.REGISTER);
        this.emitEvent(e);
    }

    @Override
    public void unplug(Plugin p) {
        plugins.remove(p);

        unregisterObserver(p);
    }

    private void configureSensor(Sensor<Measure> sensor) {
        resourceModule.webHelper().get("/sensor/:name", ctx -> {
            ctx.json(sensor.toJson());
        });
    }

    public void startWebServer() {
        // Publish the system global information

        resourceModule.webHelper().get("/description", ctx -> {
            ctx.json(metadata);
        });
        resourceModule.webHelper().get("/info/", ctx -> {
            ctx.json(metadata);
        });


        // Publish the devices information

        // plugins.forEach(p -> devices.forEach(p::process));

        // Publish the plugins information
    }


    public String toJson() {
        System.out.println(this.metadata.toJson());
        return this.metadata.toJson();
        /*ArrayList<String> sensorsDetails = new ArrayList<>();
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

        throw new UnsupportedOperationException("The system does not support this method yet");*/
    }

    public ResourceModule getResourceModule() {
        return resourceModule;
    }

    public List<Sensor<Measure>> getSensors() {
        return sensors;
    }

    private List<Device> getDevices() {
        return devices;
    }

    private List<Plugin> getPlugins() {
        return plugins;
    }

    public UUID getId() {
        return this.metadata.getId();
    }

    public String getName() {
        return this.metadata.getName();
    }

    public String getDescription() {
        return this.metadata.getDescription();
    }

    public void setName(String name) {
        this.metadata.setName(name);
    }

    public void setDescription(String description) {
        this.metadata.setDescription(description);
    }

    @Override
    public String getVersion() {
        return this.metadata.getVersion();
    }

    @Override
    public Instant getCreatedAt() {
        return null;
    }

    /**
     * Provide utility function to fetch static data from the system ans its components
     */
}
