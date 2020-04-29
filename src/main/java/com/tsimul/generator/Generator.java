package com.tsimul.generator;


import com.tsimul.engine.Engine;

/**
 * Can be used for simulated sensors
 * A real sensor does not generate data, it measures or read the data
 * An artificial sensor can simulate data
 * @param <T>
 */
public interface Generator <T> {

    /**
     * Generate some data
     * @return The generated data
     */
    T generate();

    /**
     *
     * @param task a custom generation protocol
     * @return The generated value
     */
    default T generate(Engine<T> task) {
        return task.execute();
    }


}
