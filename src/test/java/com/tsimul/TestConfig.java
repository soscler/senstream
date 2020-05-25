package com.tsimul;

import com.tsimul.generator.Generators;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public interface TestConfig {

    @BeforeAll
    public static void initAll() {

    }

    @BeforeEach
    public void init();

    @AfterEach
    public void tearDown() ;

    @AfterAll
    public static void tearDownAll() {

    }

}
