package com.tsimul.base;

import com.tsimul.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class MetadataTest implements TestConfig {

    @Override
    public void init() {

    }

    @Override
    public void tearDown() {

    }

    @Test
    @DisplayName("Test the creation of a metadata instance")
    public void creation() {
        Metadata m = new Metadata("name", "version", "description");
        assertThat(m, is(notNullValue()));
        assertThat(m.getCreatedAt(), is(instanceOf(Instant.class)));
        assertEquals("name", m.getName());
        assertEquals("version", m.getVersion());
        assertEquals("description", m.getDescription());
    }
}
