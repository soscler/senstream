package engine;

import engine.measure.Measure;
import engine.sensor.Sensor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;

public abstract class AbstractIOTSystem implements IOTSystem {

    Collection<Sensor<? extends Measure>> sensors = new ArrayList<>();

    @Override
    public void start() {
        sensors.forEach(sensor -> {
            try {
                sensor.start();
            }  catch (SensorException e) {
                e.printStackTrace();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    @Override
    public void stop() {
        sensors.forEach(Sensor::off);
    }

    public void display() {
        sensors.forEach(sensor -> {
            try {
                sensor.display();
            } catch (SensorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });
    }


    public void register(Sensor<? extends Measure> sensor) {
        sensors.add(sensor);
    }
}
