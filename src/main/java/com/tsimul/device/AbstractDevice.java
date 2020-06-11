package com.tsimul.device;

import com.tsimul.event.*;
import com.tsimul.event.data.EventData;
import com.tsimul.event.data.SensorEventData;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Class used to define all primordial fields and common methods
 */
public abstract class AbstractDevice<M extends DeviceMetadata> implements Device<M> {

    private final ObserverImpl observer;
    private final ObservableImpl observable;
    private final M metadata;

    public AbstractDevice(M metadata) {
        super();
        this.metadata = metadata;
        this.observer = new ObserverImpl(this);
        this.observable = new ObservableImpl();
    }


    @Override
    public void registerObserver(Observer observer) {
        this.observable.registerObserver(observer);
    }

    @Override
    public void registerObserver(List<Observer> observers) {
        this.observable.registerObserver(observers);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observable.unregisterObserver(observer);
    }

    @Override
    public void unregisterObserver(List<Observer> observers) {
        this.observable.unregisterObserver(observers);
    }

    @Override
    public void emitEvent(Event event) {
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
    public UUID getId() {
        return this.metadata.getId();
    }

    public String getName() {
        return this.metadata.getName();
    }

    public void setName(String name) {
        this.metadata.setName(name);
    }

    public String getDescription() {
        return this.metadata.getDescription();
    }

    public void setDescription(String description) {
        this.metadata.setDescription(description);
    }

    @Override
    public Instant getCreatedAt() {
        return this.metadata.getCreatedAt();
    }

    public String getVersion() {
        return this.metadata.getVersion();
    }

    @Override
    public String toJson() {
        return this.metadata.toJson();
    }

    @Override
    public String toString() {
        return metadata.toString();
    }

    public M getMetadata() {
        return metadata;
    }
}
