package com.tsimul.generator;

import org.awaitility.Awaitility;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomFrequencyGeneratorTest {

    public FrequencyGenerator<Double> generator;
    public long millis;
    public double min;
    public double max;

    @BeforeAll
    static public void initAll() {
    }

    @BeforeEach
    public void init() {
        millis = 4000L;
        min = -25;
        max = 25;
        generator =  Generators.doubleRandomFrequencyGenerator(millis, min, max);
        assertNotNull(generator);
    }

    @AfterEach
    public void tearDown() {

    }

    @AfterAll
    static public void tearDownAll() {

    }

    @Test
    public void generate() throws InterruptedException {
        generator.start();
        Awaitility.await()
                .atLeast(Duration.ofSeconds(1))
                .atMost(Duration.ofSeconds(5))
                .with()
                .pollInterval(Duration.ofSeconds(1))
                .pollDelay(Duration.ofSeconds(1))
                .until(generator::getValue, CoreMatchers.notNullValue());
    }

    @Test
    public void stop() {
        generator.start();
        Awaitility.await()
                .atLeast(Duration.ofSeconds(1))
                .atMost(Duration.ofSeconds(5))
                .with()
                    .pollInterval(Duration.ofSeconds(1))
                    .pollDelay(Duration.ofSeconds(1))
                    .until(generator::getValue, CoreMatchers.notNullValue());
        generator.stop();

    }
}
