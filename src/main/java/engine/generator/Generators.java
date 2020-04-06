package engine.generator;

import engine.compute.BoundedRandomDoubleEngine;
import engine.compute.RandomDoubleEngine;

/**
 * Factory class for generators
 */
public class Generators {

    private Generators() {}

    public static DoubleRandomFrequencyGenerator doubleRandomFrequencyGenerator(long millis) {
        return new DoubleRandomFrequencyGenerator(Generators.doubleRandomGenerator(), millis);
    }

    public static DoubleRandomFrequencyGenerator doubleRandomFrequencyGenerator(long millis, double min, double max) {
        return new DoubleRandomFrequencyGenerator(Generators.doubleRandomGenerator(min, max), millis);
    }

    public static DoubleRandomGenerator doubleRandomGenerator() {
        return new DoubleRandomGenerator(new RandomDoubleEngine());
    }

    public static DoubleRandomGenerator doubleRandomGenerator(double min, double max) {
        return new DoubleRandomGenerator(new BoundedRandomDoubleEngine(min, max));
    }
}
