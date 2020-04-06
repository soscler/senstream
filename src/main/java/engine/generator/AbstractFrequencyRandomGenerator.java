package engine.generator;

import engine.compute.Engine;

public abstract class AbstractFrequencyRandomGenerator<T> extends AbstractFrequencyGenerator<T> {

    public AbstractFrequencyRandomGenerator(Engine<T> t, long millis) {
        super(t, millis);
    }
}
