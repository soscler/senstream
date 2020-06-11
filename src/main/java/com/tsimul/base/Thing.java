package com.tsimul.base;

import java.time.Instant;
import java.util.UUID;

/**
 * Ease the access of the metadata fields
 */
public interface Thing<T extends Metadata> {

    UUID getId();

    Instant getCreatedAt();

    default String toJson() {
        throw new UnsupportedOperationException("This thing does not support this method yet");
    }

    /**
     * Any method that implement this method, should provide a copy of the plugin metadata object instead of the original object
     * @return a copy of the plugin metadata
     */
    T getMetadata();
}
