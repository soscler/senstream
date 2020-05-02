package com.tsimul.plugin;

import com.tsimul.util.Metadata;

/**
 * A Sub type of @see {@link Metadata}
 * @param <T> is used to make it generic the field type of the metadata
 */
public class PluginMetadata<T> extends Metadata {

    /**
     * A plugin as a type
     * The Object Type of type depends on what information the plugin creator wants to save
     * It can be a String, a Map, etc.
     */
    private T type;

    public PluginMetadata() {
        super();
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
