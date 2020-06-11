package web;

import com.tsimul.device.sensor.Sensor;
import com.tsimul.measure.SensorMeasure;
import io.javalin.http.sse.SseClient;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class SSEHandler  {

    public static Sensor<? extends SensorMeasure> sensor;

    /**
     * Dependency injection
     * @param sensor
     */
    public SSEHandler(Sensor<? extends SensorMeasure> sensor) {
        SSEHandler.sensor = sensor;
    }

    public Consumer<SseClient> getData = s -> {
        SensorMeasure m = sensor.getCurrentMeasure();
        s.sendEvent("data", m.toString());
    };

    public static void getData(SseClient s) {
        SensorMeasure m = sensor.getCurrentMeasure();
        s.sendEvent("", m.toJson());
    }

    public BiConsumer<SseClient, Sensor<? extends SensorMeasure>> biCTest = (c, s) -> {

    };
}
