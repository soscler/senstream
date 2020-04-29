import com.tsimul.WeatherIOTSystem;
import com.tsimul.device.sensor.Sensors;
import com.tsimul.device.sensor.WeatherSensor;

import java.time.Duration;


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

        WeatherIOTSystem weatherIOTSystem = new WeatherIOTSystem();
        for (int i = 0; i < 5; i++) {
            weatherIOTSystem.register(Sensors.weatherSensor(i, 0.0, 35.0, 2000L +(i+1)*1000L));
        }

        weatherIOTSystem.start();

        for (int i = 0; i < 10; i++) {
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
        Thread.sleep(2000);
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
