package com.tsimul.event;

import com.tsimul.util.Metadata;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservable implements Observable {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void registerObserver(List<? extends Observer> observers) {
        this.observers.addAll(observers);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void unregisterObserver(List<? extends Observer> observers) {
        this.observers.removeAll(observers);
    }

    @Override
    public void emitEvent() {
        this.observers.forEach(Observer::processEvent);
    }

    @Override
    public void emitEvent(Event<? extends Metadata> e) {
        this.observers.forEach(o -> o.processEvent(e));
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
