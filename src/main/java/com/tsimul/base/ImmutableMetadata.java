package com.tsimul.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tsimul.util.Util;

import java.time.Instant;
import java.util.UUID;

public class ImmutableMetadata {

    private final UUID id = UUID.randomUUID();
    private final Instant createdAt = Instant.now();

    public UUID getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String toJson() {
        try {
            return Util.jsonMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) { // Should never happen
            e.printStackTrace();
            return null;
        }
    }
}
