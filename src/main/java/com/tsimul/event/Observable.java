package com.tsimul.event;

import java.util.List;

public interface Observable {

    void registerObserver(Observer observer);
    void registerObserver(List<? extends Observer> observers);
    void unregisterObserver(Observer observer);
    void unregisterObserver(List<? extends Observer> observers);
    void emitEvent();
    void emitEvent(Event event);
}
