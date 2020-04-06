package engine.measure;

import engine.sensor.Sensor;

import java.io.Serializable;

public class WeatherMeasure extends MeasureAbs<WeatherMeasure> implements Serializable, Measure {

    public static final long serialVersionUID = 1234L;

    public WeatherMeasure(Sensor<WeatherMeasure> sensor) {
        super(sensor);
    }
}
