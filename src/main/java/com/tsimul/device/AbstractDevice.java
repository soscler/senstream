package com.tsimul.device;

import com.tsimul.event.*;

import java.util.List;

/**
 * Class used to define all primordial fields and common methods
 */
public abstract class AbstractDevice implements Device {

    private final ObserverImpl observer;
    private final ObservableImpl observable;

    public AbstractDevice() {
        super();
        this.observer = new ObserverImpl(this);
        this.observable = new ObservableImpl();
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
}
