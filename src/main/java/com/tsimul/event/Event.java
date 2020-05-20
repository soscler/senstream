package com.tsimul.event;

import com.tsimul.util.Metadata;

/**
 * TODO: Add generic parameter to represent the from metadata
 */
public class Event<T extends Metadata> {

    private EventType type;
    private Metadata metadata;
    private final T _from;

    public Event(T from) {
        _from = from;
    }


    public EventType getType() {
        return type;
    }

    public Event setType(EventType type) {
        this.type = type;
        return this;
    }

    public T from() {
        return _from;
    }

    public enum  EventType {
        ON, OFF, UPDATE, REGISTER, UNREGISTER
    }
}
