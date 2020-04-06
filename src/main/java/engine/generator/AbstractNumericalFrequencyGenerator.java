package engine.generator;

public abstract class AbstractNumericalFrequencyGenerator<T extends Number>
        extends AbstractFrequencyGenerator<T> implements NumericalFrequencyGenerator<T> {

    public AbstractNumericalFrequencyGenerator(NumericalGenerator<T> t, long millis) {
        super(t, millis);
    }
}
