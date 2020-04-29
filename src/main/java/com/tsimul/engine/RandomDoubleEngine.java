package com.tsimul.engine;

import java.util.concurrent.ThreadLocalRandom;

public class RandomDoubleEngine implements Engine<Double> {

    @Override
    public Double execute() {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        return r.nextDouble();
    }
}
