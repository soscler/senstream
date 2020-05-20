package com.tsimul;

import com.tsimul.util.Metadata;
import io.javalin.Javalin;

public class WeatherIOTSystem extends AbstractIOTSystem {

    public WeatherIOTSystem(Javalin app) {
        super(app);
    }

    public WeatherIOTSystem(Metadata metadata, Javalin app) {
        super(metadata, app);
    }
}
