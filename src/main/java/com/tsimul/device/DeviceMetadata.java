package com.tsimul.device;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tsimul.base.Metadata;
import com.tsimul.util.Util;
import org.jetbrains.annotations.NotNull;

public class DeviceMetadata extends Metadata {

    private double latitude;
    private double longitude;

    public DeviceMetadata() {
        super("DefaultDeviceName", "DefaultDeviceVersion", "defaultDeviceDescription");
    }

    public DeviceMetadata(@NotNull String name, @NotNull String version, @NotNull String description) {
        super(name, version, description);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toJson() {
        try {
            return Util.jsonMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) { // Should never happen
            e.printStackTrace();
            return null;
        }
        // throw new UnsupportedOperationException("This method is not yet implemented");
    }
}
