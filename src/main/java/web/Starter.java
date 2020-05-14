package web;

import com.tsimul.device.sensor.Sensors;
import com.tsimul.device.sensor.WeatherSensor;
import com.tsimul.exception.SensorException;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import lombok.extern.slf4j.Slf4j;

import static io.javalin.apibuilder.ApiBuilder.*;

@Slf4j
public class Starter {

    public static void main(String[] args) {

        WeatherSensor sensor = Sensors.weatherSensor(null, 0.0, 35.0, 2000L);
        try {
            sensor.start();
            log.info("Sensor on...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SensorException e) {
            log.trace("{}", e.getMessage());
        }
        SSEHandler.sensor = sensor;

        server();

    }

    static void server() {

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        app.routes(() -> {
           path("/", () -> {
               get(c -> c.result("Server is up and running..."));
           });
           path("sse", () -> {
               sse(SSEHandler::getData);
           });
        });

        app.start(3000);
    }
}
