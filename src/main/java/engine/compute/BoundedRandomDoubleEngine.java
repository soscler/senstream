package engine.compute;

import java.util.concurrent.ThreadLocalRandom;

public class BoundedRandomDoubleEngine implements Engine<Double> {

    private double min;
    private double max;

    BoundedRandomDoubleEngine(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Double execute() {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        return r.nextDouble(min, max);
    }
}
