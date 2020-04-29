package com.tsimul.generator;

public interface FrequencyGenerator<T> {

    /**
     * Start the generation in the current thread
     */
    public void start();

    /**
     * Stop the generation in the current thread
     */
    public void stop();


    T getValue();

    /**
     * It is not allowed to modify the value of a generator
     */
    default void setValue() {
        throw new UnsupportedOperationException();
    }
}
