package com.tsimul.plugin;

public class AbstractPlugin implements Plugin {

    String id;
    String name;
    String description;

    public void process() {
        throw new UnsupportedOperationException("This plugin has not yet implemented this method");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
