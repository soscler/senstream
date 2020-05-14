package com.tsimul.generator;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public abstract class AbstractFrequencyGenerator<T> implements FrequencyGenerator<T> {

    private long millis;
    private T value = null;
    private Generator<T> generator;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public AbstractFrequencyGenerator(Generator<T> generator, long millis) {
        Objects.requireNonNull(generator);
        this.millis = millis;
        this.generator = generator;
    }

    /**
     * Return the last value the generator has generated
     * @return the value the generator has generated
     */
    public T getValue() {
        return this.value;
    }

    @Override
    public void start() {
        AtomicBoolean error = new AtomicBoolean();
        error.set(false);
        executorService.submit(() -> {
            try {
                while (!error.get()) {
                    Thread.sleep(Duration.ofSeconds(this.millis).toMillis());
                    this.value = generator.generate();
                }
            } catch (InterruptedException e) {
                log.warn(e.getMessage());
                error.set(true);
                this.value = null;
                Thread.currentThread().interrupt();
            }
        });
    }

    @Override
    public void stop() {
        this.value = null;
        executorService.shutdownNow();
    }
}
