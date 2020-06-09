package com.tsimul.event;

import com.tsimul.base.Metadata;
import com.tsimul.event.data.EventData;

/**
 * TODO: Add generic parameter to represent the from metadata
 * TODO: Use the generic parameter to set the data this event carries
 */
public class Event {

    private final EventType type;
    private final Metadata from;
    // We can use this field for security purpose, an observer can/should only process events that it listen to
    // private final Metadata _to;

    private final EventData data;

    public Event(EventType type, Metadata from, EventData data) {
        this.type = type;
        this.from = from;
        this.data = data;
    }

    public EventType getType() {
        return type;
    }

    public Metadata getFrom() {
        return from;
    }

    public EventData getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", from=" + from +
                ", data=" + data +
                '}';
    }

    public enum  EventType {
        ON, OFF, UPDATE, REGISTER, UNREGISTER, DATA
    }
}
