package com.tsimul.event;

import com.tsimul.base.Metadata;
import com.tsimul.event.data.EventData;
import jdk.jfr.EventType;

import java.util.List;

/**
 * TODO: Expose the event that this Observer wants to listen to
 */
public interface Observer {


    void subscribeToObservable(Observable observable);

    void subscribeToObservable(List<? extends Observable> observables);

    void unsubscribeFromObservable(Observable observable);

    void unsubscribeFromObservable(List<? extends Observable> observables);

    default void processEvent(Event event) {throw new UnsupportedOperationException("This observer has not yet implemented the process method");}

    /**
     * TODO: Create this method to specific the events this observer wants to listen to observer
     * void subscribeToObservableEvent(Observer o, EventType type)
     * TODO: Create this method to specific the events this group of observers want to listen to observer
     * void subscribeToEvent(EventType type, List<? extends Observer> observers)
     */

    default void subscribeToObservableEvent(Observer o, EventType... type) {
        throw new UnsupportedOperationException("This method is not yet implemented by this Observer");
    }
}
