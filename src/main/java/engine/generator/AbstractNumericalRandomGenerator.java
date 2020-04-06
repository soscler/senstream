package engine.generator;

import engine.compute.Engine;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


public abstract class AbstractNumericalRandomGenerator<T extends Number> extends AbstractNumericalGenerator<T> {

    private Engine<T> task;

    /**
     * Minimal bound for the generator
     */
    private double min = Double.MIN_VALUE;

    /**
     * Maximal bound for the generator
     */
    private double max = Double.MAX_VALUE;


    public AbstractNumericalRandomGenerator(Engine<T> t) {
        super(t);
        Objects.requireNonNull(t);
        this.task = t;
    }

    public AbstractNumericalRandomGenerator(double min, double max) {
        super(null);
        this.min = min;
        this.max = max;
        this.task = null;
    }


    @Override
    public T generate() {
        Double generated;
        ThreadLocalRandom r;
        if(this.task != null) {
            generated = task.execute().doubleValue();
        } else {
            r = ThreadLocalRandom.current();
            generated = r.nextDouble(min, max);
        }
        return (T) generated;
    }
}
