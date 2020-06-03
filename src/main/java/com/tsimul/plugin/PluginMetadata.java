package com.tsimul.plugin;

import com.tsimul.base.Metadata;
import com.tsimul.configuration.ConfigDetail;
import com.tsimul.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * A Sub type of @see {@link Metadata}
 */
public class PluginMetadata extends Metadata {


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
     *      subscribe: {
     *          allEvents {
     *              eventType: [UPDATE, ON, OFF, ALL] // Limité les évènement que le plugin peut écouter
     *          },
     *          sensorsEvents: {
     *              sensorsType: [NUMERICAL, BOOLEAN],
     *              eventType: [UPDATE, ON OFF, ALL]
     *          },
     *          actuatorsEvents: {
     *              actuatorType: [GAUGE, BINARY],
     *              eventType: [UPDATE, ON OFF, ALL]
     *          }
     *      }
     *  }
     * - Créer une class PluginHandler
     *
     */

    private ConfigDetail.PluginType type;
    private ConfigDetail.PluginSubType subType;
    private ConfigDetail.PluginDetail.PluginSubscriptionDetail subscriptionDetail;

    public PluginMetadata(@NotNull String name, @NotNull String version, @NotNull String description) {
        super(name, version, description);
    }

    private void setType(ConfigDetail.PluginType type) {
        this.type = type;
    }

    public ConfigDetail.PluginType getType() {
        return type;
    }

    public ConfigDetail.PluginSubType getSubType() {
        return subType;
    }

    private void setSubType(ConfigDetail.PluginSubType subType) {
        this.subType = subType;
    }

    public ConfigDetail.PluginDetail.PluginSubscriptionDetail getSubscriptionDetail() {
        return subscriptionDetail;
    }

    public void setSubscriptionDetail(ConfigDetail.PluginDetail.PluginSubscriptionDetail subscriptionDetail) {
        this.subscriptionDetail = subscriptionDetail;
    }
}
