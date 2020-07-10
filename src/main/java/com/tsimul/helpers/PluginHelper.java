package com.tsimul.helpers;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Singleton;
import com.tsimul.event.*;
import com.tsimul.event.Observable;
import com.tsimul.plugin.Plugin;

import java.util.*;
import java.util.concurrent.Executors;

/**
 * This class behaves has a monitor
 * It receives the events and then follow it to the respective plugins that are subscribed to this event
 */
@Singleton
public class PluginHelper {

    // private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Map<String, Observable> observers = null;

    private final Multimap<Event.EventType, Plugin> plugins = LinkedListMultimap.create();


    PluginHelper() {
    }

    /**
     * Spawn many executor and decrease waiting time
     * @param e
     */
    public void broadcastEvent(Event e) {
        plugins.values().forEach(p -> {
            Executors.newSingleThreadExecutor().submit(() -> {
                p.processEvent(e);
            });
        });
    }

    /**
     * Forward an event to the plugins that are subscribed to this event
     * @param e
     */
    public void forwardEvent(Event e) {
        plugins.get(e.getType())
                .forEach(p -> {
                    Executors.newSingleThreadExecutor().submit(() -> {
                        p.processEvent(e);
                    });
                });
    }

    /**
     * Register a plugin to the list of events it wants to listen
     * TODO: Should I move the plugin metadata to the observer ?
     * TODO: So that the observer class is responsible of setting the proprieties of the events it wants to listen to
     * @param p
     */
    public void subscribePluginToEvent(Plugin p) {
        p.getMetadata().getSubscriptionDetail()
                .getAllEvents()
                .getEventTypes()
                .forEach(e -> plugins.put(e, p));
    }

    /**
     * TODO: Create a method that subscribe this helper to the Observable a plugin wants to listen to
     * TODO: This helper should then implements the Observer class
     *
     */

}
