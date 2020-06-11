package com.tsimul.generator;

public class DoubleRandomFrequencyGenerator extends AbstractFrequencyGenerator<Double> {

    public DoubleRandomFrequencyGenerator(Generator<Double> generator, long frequency) {
        super(generator, frequency);
    }
}
