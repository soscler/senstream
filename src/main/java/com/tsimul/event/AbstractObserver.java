package com.tsimul.event;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObserver implements Observer {

    // TODO: Replace ArrayList with HashSet
    List<Observable> subjects = new ArrayList<>();

    /**
     * The actual processor
     * This object is used to invoke methods that are specific to each observer
     * For e.g. see the processEvent() method
     */
    private final Observer processor;

    public AbstractObserver(Observer processor) {
        this.processor = processor;
    }

    @Override
    public synchronized void processEvent(Event e) {
        this.processor.processEvent(e);
    }

    @Override
    public void subscribeToObservable(Observable observable) {
        observable.registerObserver(this);
        subjects.add(observable);
    }

    @Override
    public void subscribeToObservable(List<? extends Observable> observables) {
        observables.forEach(this::subscribeToObservable);
        // subjects.addAll(observables);
    }


    @Override
    public void unsubscribeFromObservable(Observable observable) {
        observable.unregisterObserver(this);
        subjects.remove(observable);
    }

    @Override
    public void unsubscribeFromObservable(List<? extends Observable> observables) {
        observables.forEach(this::unsubscribeFromObservable);
        // subjects.removeAll(observables);
    }

    public List<Observable> getSubjects() {
        return subjects;
    }
}
