package engine.generator;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public abstract class AbstractNumericalRandomFrequencyGenerator<T extends Number> extends AbstractNumericalFrequencyGenerator<T>
        implements NumericalRandomFrequencyGenerator<T> {

    public AbstractNumericalRandomFrequencyGenerator(NumericalRandomGenerator<T> generator, long millis) {
        super(generator, millis);
    }

}
