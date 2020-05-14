import com.tsimul.IOTSystem;
import com.tsimul.IOTSystemBuilder;
import com.tsimul.IOTSystemImpl;
import com.tsimul.WeatherIOTSystem;
import com.tsimul.configuration.Config;
import com.tsimul.device.sensor.Sensor;
import com.tsimul.device.sensor.Sensors;
import com.tsimul.device.sensor.WeatherSensor;
import com.tsimul.event.Observable;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Application {

    /**
     * Idée:
     * Lire le fichier de configuration du système
     * - Puis créer le système
     * - Créer un web server et l'attacher au système ?
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {

        String dataPath = "src/main/java/com/tsimul/configuration/example.json";
        String data = new String(Files.readAllBytes(Paths.get(dataPath)));
        Config config = new Config(data);
        IOTSystemImpl system = (IOTSystemImpl) new IOTSystemBuilder(config).build();
        system.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration " + i);
            long start = System.currentTimeMillis();
            Thread.sleep(Duration.ofSeconds(5).toMillis());
            system.display();
            long stop = System.currentTimeMillis();
            System.out.println("Duration " + (stop - start)/1000L);
        }
        system.stop();
        Thread.sleep(200);
        system.display();
        Thread.sleep(2000);
    }

    static void startEngine(long durationSec) throws Exception {


       /* WeatherSensor sensor = new WeatherSensor(5, 0.0, 35.0, 2);
        System.out.println("Start weather temperature generation...");
        Thread.sleep(Duration.ofSeconds(durationSec).toMillis());
        sensor.off();
        System.out.println("Stop weather temperature generation...");
        sensor.display();*/

    }


}
