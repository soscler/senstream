package com.tsimul.event;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservable implements Observable {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void registerObserver(List<Observer> observers) {
        this.observers.addAll(observers);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void unregisterObserver(List<Observer> observers) {
        this.observers.removeAll(observers);
    }

    @Override
    public void emitEvent(Event e) {
        this.observers.forEach(o -> o.processEvent(e));
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
