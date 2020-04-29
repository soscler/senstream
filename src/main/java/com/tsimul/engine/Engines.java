package com.tsimul.engine;

public class Engines {

    Engine<Double> randomDoubleEngine() {
        return new RandomDoubleEngine();
    }

    Engine<Double> boundedRandomDoubleEngine(double min, double max) {
        return new BoundedRandomDoubleEngine(min, max);
    }
}
