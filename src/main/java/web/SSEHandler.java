package web;

import com.tsimul.device.sensor.Sensor;
import com.tsimul.measure.Measure;
import io.javalin.http.sse.SseClient;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class SSEHandler  {

    public static Sensor<? extends Measure> sensor;

    /**
     * Dependency injection
     * @param sensor
     */
    public SSEHandler(Sensor<? extends Measure> sensor) {
        SSEHandler.sensor = sensor;
    }

    public Consumer<SseClient> getData = s -> {
        Measure m = sensor.getCurrentMeasure();
        s.sendEvent("data", m.toString());
    };

    public static void getData(SseClient s) {
        Measure m = sensor.getCurrentMeasure();
        s.sendEvent("", m.toJson());
    }

    public BiConsumer<SseClient, Sensor<? extends Measure>> biCTest = (c,s) -> {

    };
}
