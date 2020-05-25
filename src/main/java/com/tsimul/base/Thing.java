package com.tsimul.base;

import java.time.Instant;
import java.util.UUID;

/**
 * Ease the access of the metadata fields
 */
public interface Thing {

    UUID getId();
    String getName();
    Instant getCreatedAt();
    String getVersion();
    String getDescription();
    String toJson();
}
