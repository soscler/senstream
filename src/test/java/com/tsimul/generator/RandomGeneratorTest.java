package com.tsimul.generator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tsimul.TestConfig;
import org.junit.jupiter.api.*;


public class RandomGeneratorTest implements TestConfig {

    public Generator<Double> generator;
    public double min;
    public double max;

    @BeforeAll
    static public void initAll() {

    }

    @BeforeEach
    public void init() {
        min = -25;
        max = 25;
        generator =  Generators.doubleRandomGenerator(min, max);
        assertNotNull(generator);
    }

    @AfterEach
    public void tearDown() {

    }

    @AfterAll
    public static void tearDownAll() {

    }

    @Test
    public void generate() throws InterruptedException {
        double generated = generator.generate();
        assertTrue(generated >= min && generated <= max);
    }
}
