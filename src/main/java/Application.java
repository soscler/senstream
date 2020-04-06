import engine.SSEHandler;
import engine.WeatherIOTSystem;
import engine.sensor.Sensors;
import engine.sensor.WeatherSensor;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.time.Duration;

@Slf4j
public class Application {

    public static void main(String[] args) throws Exception {

        WeatherIOTSystem weatherIOTSystem = new WeatherIOTSystem();
        for (int i = 0; i < 5; i++) {
            weatherIOTSystem.register(Sensors.weatherSensor(i, 0.0, 35.0, 2000L +(i+1)*1000L));
        }

        weatherIOTSystem.start();


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
        for (int i = 0; i < 2; i++) {
            long start = System.currentTimeMillis();
            Thread.sleep(Duration.ofSeconds(2).toMillis());
            weatherIOTSystem.display();
            long stop = System.currentTimeMillis();
            System.out.println("Duration " + (stop - start)/1000L);
        }
        weatherIOTSystem.stop();
        Thread.sleep(200);
        weatherIOTSystem.display();
        Thread.sleep(2000);
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
