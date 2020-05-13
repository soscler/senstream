import com.tsimul.IOTSystem;
import com.tsimul.IOTSystemBuilder;
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
        IOTSystem system = new IOTSystemBuilder(config).config(config).build();

        /*com.tsimul.IOTSystemImpl weatherIOTSystem = new com.tsimul.IOTSystemImpl();
        for (int i = 0; i < 5; i++) {
            weatherIOTSystem.register(Sensors.weatherSensor(i, 0.0, 35.0, 2000L +(i+1)*1000L));
        }

        WeatherSensor sensor = Sensors.weatherSensor(5, 0.0, 35.0, 1000L);
        weatherIOTSystem.register(sensor);

        weatherIOTSystem.subscribeToObservable(weatherIOTSystem.getSensors());

        weatherIOTSystem.start();*/

        /*for (int i = 0; i < 10; i++) {
            System.out.println("Iteration " + i);
            long start = System.currentTimeMillis();
            Thread.sleep(Duration.ofSeconds(2).toMillis());
            weatherIOTSystem.display();
            long stop = System.currentTimeMillis();
            System.out.println("Duration " + (stop - start)/1000L);
        }
        weatherIOTSystem.stop();
        Thread.sleep(200);
        weatherIOTSystem.display();
        Thread.sleep(2000);*/
    }


    static void startEngine(long durationSec) throws Exception {


        WeatherSensor sensor = new WeatherSensor(5, 0.0, 35.0, 2);
        System.out.println("Start weather temperature generation...");
        Thread.sleep(Duration.ofSeconds(durationSec).toMillis());
        sensor.off();
        System.out.println("Stop weather temperature generation...");
        sensor.display();

    }


}
