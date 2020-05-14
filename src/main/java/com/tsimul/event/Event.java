package com.tsimul.event;

import com.tsimul.util.Metadata;

public class Event {

    private String type;
    private Metadata metadata;

    public String getType() {
        return type;
    }

    public Event setType(String type) {
        this.type = type;
        return this;
    }

    public enum  EventType {
        ON, OFF, UPDATE, REGISTER, UNREGISTER
    }
}
