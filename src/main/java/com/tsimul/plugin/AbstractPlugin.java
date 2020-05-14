package com.tsimul.plugin;

import com.tsimul.util.Metadata;

public abstract class AbstractPlugin<M extends Metadata> implements Plugin {

    protected M metadata;

    public long getId() {
        return this.metadata.getId();
    }

    public void setId(long id) {
        this.metadata.setId(id);
    }

    public String getName() {
        return this.metadata.getName();
    }

    public void setName(String name) {
        this.metadata.setName(name);
    }

    public String getDescription() {
        return this.metadata.getDescription();
    }

    public void setDescription(String description) {
        this.metadata.setDescription(description);
    }


    @Override
    public String toString() {
        return metadata.toString();
    }

}
