package com.tsimul.event;

import com.tsimul.util.Metadata;

public class Event {

    private String type;

    public String getType() {
        return type;
    }

    public Event setType(String type) {
        this.type = type;
        return this;
    }
}
