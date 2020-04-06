import engine.SSEHandler;
import engine.sensor.WeatherSensor;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class Application {

    public static void main(String[] args) throws Exception {
        WeatherSensor sensor = new WeatherSensor(5, 0.0, 35.0, 2);

        {
            // Engine configuration
            Thread t = new Thread(sensor);
            t.start();
        }

        {
            // Web server configuration
            Javalin app = server();
            app.get("/", c-> {
                c.result("Server App is running");
            });
            // SSEHandler.sensor = sensor;
            SSEHandler s = new SSEHandler(sensor);
            app.sse("/sse/", SSEHandler::getData);
        }

        // Avoid the main thread to exist
        while (true) {
            Thread.sleep(Duration.ofSeconds(2).toMillis());
        }

    }


    static void startEngine(long durationSec) throws Exception {


        WeatherSensor sensor = new WeatherSensor(5, 0.0, 35.0, 2);
        System.out.println("Start weather temperature generation...");
        Thread t = new Thread(sensor);
        t.start();
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
