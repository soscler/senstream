import engine.SSEHandler;
import engine.sensor.Sensors;
import engine.sensor.WeatherSensor;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.time.Duration;

@Slf4j
public class Application {

    public static void main(String[] args) throws Exception {
        WeatherSensor sensor = Sensors.weatherSensor(5, 0.0, 35.0, 2000);

        sensor.on();
        sensor.start();



       /* {
            // Web server configuration
            Javalin app = server();
            app.get("/", c-> {
                c.result("Server App is running");
            });
            // SSEHandler.sensor = sensor;
            SSEHandler s = new SSEHandler(sensor);
            app.sse("/sse/", SSEHandler::getData);
        }*/

        // Avoid the main thread to exist
        while (true) {
            long start = System.currentTimeMillis();
            Thread.sleep(Duration.ofSeconds(2).toMillis());
            sensor.display();
            long stop = System.currentTimeMillis();
            System.out.println("Duration " + (stop - start)/1000L);
        }

    }


    static void startEngine(long durationSec) throws Exception {


        WeatherSensor sensor = new WeatherSensor(5, 0.0, 35.0, 2);
        System.out.println("Start weather temperature generation...");
        Thread.sleep(Duration.ofSeconds(durationSec).toMillis());
        sensor.off();
        System.out.println(sensor.isOn());
        System.out.println("Stop weather temperature generation...");
        sensor.display();

    }

    static Javalin server() {
        Javalin app = Javalin.create(c -> {
            c.enableCorsForOrigin("http://localhost:4200");
        });
        app.start(3000);
        return app;
    }
}
