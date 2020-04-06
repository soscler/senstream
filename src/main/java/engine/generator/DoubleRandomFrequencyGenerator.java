package engine.generator;

public class DoubleRandomFrequencyGenerator extends AbstractFrequencyGenerator<Double> {

    public DoubleRandomFrequencyGenerator(Generator<Double> generator, long millis) {
        super(generator, millis);
    }
}
