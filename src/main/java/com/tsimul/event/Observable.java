package com.tsimul.event;

import com.tsimul.base.Metadata;
import com.tsimul.event.data.EventData;

import java.util.List;

/**
 * Un observable est paramétré par un type T qui correspond au type d'évenements qu'il produit
 * TODO: Expose the events that this Observable emits
 * TODO: Create SingleObserver that don't care about filtering the events
 */
public interface Observable {

    void registerObserver(Observer observer);

    void registerObserver(List<Observer> observers);

    void unregisterObserver(Observer observer);

    void unregisterObserver(List<Observer> observers);

    void emitEvent(Event event);

    /**
     * TODO: Create this method to notify a specific observer o the event e
     * void emitEvent(Event e, Observer o)
     * TODO: Create this method to notify a specific group of observers the event e
     * void emitEvent(Event e, List<? extends Observer> observers)
     */
}
