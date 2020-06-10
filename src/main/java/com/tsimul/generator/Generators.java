package com.tsimul.generator;

import com.tsimul.engine.BoundedRandomDoubleEngine;
import com.tsimul.engine.RandomDoubleEngine;

/**
 * Factory class for generators
 */
public class Generators {

    private Generators() {}

    public static DoubleRandomFrequencyGenerator doubleRandomFrequencyGenerator(long frequency) {
        return new DoubleRandomFrequencyGenerator(Generators.doubleRandomGenerator(), frequency);
    }

    public static DoubleRandomFrequencyGenerator doubleRandomFrequencyGenerator(double min, double max, long frequency) {
        return new DoubleRandomFrequencyGenerator(Generators.doubleRandomGenerator(min, max), frequency);
    }

    public static DoubleRandomGenerator doubleRandomGenerator() {
        return new DoubleRandomGenerator(new RandomDoubleEngine());
    }

    public static DoubleRandomGenerator doubleRandomGenerator(double min, double max) {
        return new DoubleRandomGenerator(new BoundedRandomDoubleEngine(min, max));
    }
}
