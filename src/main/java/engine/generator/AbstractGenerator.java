package engine.generator;

import engine.compute.Engine;

public abstract class AbstractGenerator<T> implements Generator<T> {

    private Engine<T> task;

    public AbstractGenerator(Engine<T> t) {
        this.task = t;
    }

    @Override
    public T generate() {
        return task.execute();
    }
}
