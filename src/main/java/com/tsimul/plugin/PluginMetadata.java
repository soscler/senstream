package com.tsimul.plugin;

import com.tsimul.base.Metadata;
import org.jetbrains.annotations.NotNull;

/**
 * A Sub type of @see {@link Metadata}
 * @param <T> is used to make it generic the field type of the metadata
 */
public class PluginMetadata<T> extends Metadata {

    /**
     * A plugin as a type
     * The Object Type of type depends on what information the plugin creator wants to save
     * It can be a String, a Map, etc.
     *
     *
     * Utilisez plugin metadata pour communiquer avec le system
     * - Quand le system ajoute un plugin, il appelle la fonction plugin()
     * Dans cette fonction le system lit les metadata du plugin
     * Type de metadata
     *  - plugin : {
     *      metadata: {
     *          type: transport or kafka ? // Generic or specific
     *      }
     *      listen: {
     *          event {
     *              type: [update] // Limité les évènement que le plugin peut écouter
     *          },
     *          sensor: {
     *              type: [numerical]
     *          },
     *          actuators: {
     *              type: [on, off]
     *          }
     *      }
     *  }
     * - Créer une class PluginHandler
     *
     */
    private T type;

    public PluginMetadata(@NotNull String name, @NotNull String version, @NotNull String description) {
        super(name, version, description);
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
