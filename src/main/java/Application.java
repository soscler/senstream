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
import com.tsimul.helpers.InjectorModule;

import java.nio.charset.StandardCharsets;
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
        String data = new String(Files.readAllBytes(Paths.get(dataPath)), StandardCharsets.UTF_8);
        Config config = new Config(data);
        Injector injector = Guice.createInjector(new InjectorModule());
        IOTSystem system = injector.getInstance(IOTSystemBuilder.class).config(config).build();
        system.start();

        for (int i = 0; i < 100; i++) {
            Thread.sleep(Duration.ofSeconds(5).toMillis());
        }
        system.stop();
    }
}
