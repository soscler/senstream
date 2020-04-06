package engine.generator;

import engine.compute.Engine;

public abstract class AbstractNumericalGenerator<T extends Number> extends AbstractGenerator<T>  implements NumericalGenerator<T> {

    public AbstractNumericalGenerator(Engine<T> t) {
        super(t);
    }
}
