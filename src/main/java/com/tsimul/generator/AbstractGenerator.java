package com.tsimul.generator;

import com.tsimul.engine.Engine;

public abstract class AbstractGenerator<T> implements Generator<T> {

    private final Engine<T> task;

    public AbstractGenerator(Engine<T> t) {
        this.task = t;
    }

    @Override
    public T generate() {
        return task.execute();
    }
}
