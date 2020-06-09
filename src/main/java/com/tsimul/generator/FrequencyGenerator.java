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
}

