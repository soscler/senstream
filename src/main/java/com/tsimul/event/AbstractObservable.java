package com.tsimul.event;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.tsimul.plugin.Plugin;
import com.tsimul.plugin.PluginMetadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractObservable implements Observable {

    List<Observer> observers = new ArrayList<>();

    /**
     * TODO: Create a FilterableObservable and make it inherit the Observable functionalities and augment it with eventType
     * filter option
     */
    private final Multimap<Event.EventType, Observer> observersS = LinkedListMultimap.create();

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
