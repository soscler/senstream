package com.tsimul.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tsimul.util.Util;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.UUID;

/**
 * Contains basic information for any component of the system
 * TODO: Should it implement Thing ?
 */
public class Metadata {

    // TODO: Make all field final ? In fact editing a thing can be seen as destroying and creating new ? No recycling ?
    /**
     * If we allow edition, what happen when an observer subscribes to an observable via the observable name and this
     * observable changes its name ?
     */
    private final UUID id = UUID.randomUUID();
    private final Instant createdAt = Instant.now();

    private final String version;
    private String name;
    private String description;

    public Metadata(@NotNull String name, @NotNull String version, @NotNull String description) {
        this.name = name;
        this.version = version;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public String toJson() {
        try {
            return Util.jsonMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) { // Should never happen
            e.printStackTrace();
            return null;
        }
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
