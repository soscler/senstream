import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tsimul.IOTSystem;
import com.tsimul.IOTSystemBuilder;
import com.tsimul.configuration.Config;
import com.tsimul.device.AbstractDevice;
import com.tsimul.device.Device;
import com.tsimul.device.actuator.AbstractActuator;
import com.tsimul.device.actuator.Actuator;
import com.tsimul.device.sensor.AbstractSensor;
import com.tsimul.device.sensor.Sensor;
import com.tsimul.event.Observable;
import com.tsimul.helpers.ResourceModule;

import java.nio.file.Files;
import java.nio.file.Paths;
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

        String dataPath = "src/main/java/com/tsimul/configuration/example.json";
        String data = new String(Files.readAllBytes(Paths.get(dataPath)));
        Config config = new Config(data);
        Injector injector = Guice.createInjector(new ResourceModule());
        IOTSystem system = injector.getInstance(IOTSystemBuilder.class).config(config).build();
        system.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration " + i);
            long start = System.currentTimeMillis();
            Thread.sleep(Duration.ofSeconds(5).toMillis());
            system.display();
            if(i == 3) {
                system.getSensors().forEach(s -> {
                    System.out.println(s instanceof Sensor);
                    System.out.println(s instanceof Device);
                    System.out.println(s instanceof AbstractSensor);
                    System.out.println(s instanceof AbstractDevice);
                    System.out.println(s instanceof Actuator);
                    System.out.println(s instanceof AbstractActuator);
                    System.out.println(s instanceof Observable);
                    System.out.println(s instanceof IOTSystem);
                });
                system.unsubscribeFromObservable(system.getSensors());
            }
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
