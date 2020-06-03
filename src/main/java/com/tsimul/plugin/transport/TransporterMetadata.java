package com.tsimul.plugin.transport;

import com.tsimul.plugin.PluginMetadata;
import org.jetbrains.annotations.NotNull;

public class TransporterMetadata extends PluginMetadata {

    public TransporterMetadata() {
        super("DefaultTransporterPlugin", "DefaultVersion", "DefaultDescription");
    }

    public TransporterMetadata(@NotNull String name, @NotNull String version, @NotNull String description) {
        super(name, version, description);
    }
}
