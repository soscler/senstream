package com.tsimul.event;

import com.tsimul.util.Metadata;

import java.util.List;

public interface Observable {

    void registerObserver(Observer observer);
    void registerObserver(List<? extends Observer> observers);
    void unregisterObserver(Observer observer);
    void unregisterObserver(List<? extends Observer> observers);
    void emitEvent();
    void emitEvent(Event<? extends Metadata> event);

    /**
     * TODO: Create this method to notify a specific observer o the event e
     * void emitEvent(Event e, Observer o)
     * TODO: Create this method to notify a specific group of observers the event e
     * void emitEvent(Event e, List<? extends Observer> observers)
     */
}
