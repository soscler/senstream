package com.tsimul;

import com.google.common.collect.Maps;
import com.tsimul.event.Event;
import com.tsimul.event.Observable;
import com.tsimul.event.Observer;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PluginHelper {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Map<String, Observable> observers = null;

    public void broadcast(Event e) {}

}
