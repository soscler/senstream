package engine;

import engine.measure.Measure;
import engine.sensor.Sensor;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractIOTSystem implements IOTSystem {

    Collection<Sensor<? extends Measure>> sensors = new ArrayList<>();
}
