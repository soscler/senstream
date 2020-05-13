package com.tsimul.event;

import java.util.List;

public interface Observer {

    default void processEvent() {throw new UnsupportedOperationException("This observer has not yet implemented the process method");}
    default void processEvent(Event e) {throw new UnsupportedOperationException("This observer has not yet implemented the process method");}

    void subscribeToObservable(Observable observable);
    void subscribeToObservable(List<? extends Observable> observables);

    void unsubscribeFromObservable(Observable observable);
    void unsubscribeFromObservable(List<? extends Observable> observables);
}
