package com.tsimul.event;

import com.tsimul.base.Metadata;

import java.util.List;

/**
 * TODO: Expose the event that this Observer wants to listen to
 */
public interface Observer {

    default void processEvent() {throw new UnsupportedOperationException("This observer has not yet implemented the process method");}
    default void processEvent(Event<? extends Metadata> e) {throw new UnsupportedOperationException("This observer has not yet implemented the process method");}

    void subscribeToObservable(Observable observable);
    void subscribeToObservable(List<? extends Observable> observables);

    void unsubscribeFromObservable(Observable observable);
    void unsubscribeFromObservable(List<? extends Observable> observables);

    /**
     * TODO: Create this method to specific the events this observer wants to listen to observer
     * void subscribeToObservableEvent(Observer o, EventType type)
     * TODO: Create this method to specific the events this group of observers want to listen to observer
     * void subscribeToEvent(EventType type, List<? extends Observer> observers)
     */
}
