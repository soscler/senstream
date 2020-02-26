package engine;

import io.javalin.http.sse.SseClient;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class SSEHandler  {

    public static Sensor sensor;

    /**
     * Dependency injection
     * @param sensor
     */
    public SSEHandler(Sensor sensor) {
        this.sensor = sensor;
    }

    public Consumer<SseClient> getData = s -> {
        Measure m = sensor.getCurrentMeasure();
        s.sendEvent("data", m.toString());
    };

    public static void getData(SseClient s) {
        Measure m = sensor.getCurrentMeasure();
        s.sendEvent("", m.toJson());
    }

    public BiConsumer<SseClient, Sensor> biCTest = (c,s) -> {

    };
}
