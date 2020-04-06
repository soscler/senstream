package engine.measure;

import engine.sensor.Sensor;

import java.io.Serializable;

public class WeatherMeasure extends MeasureAbs implements Serializable, Measure {

    public final static long serialVersionUID = 1234L;

    public WeatherMeasure(Sensor<WeatherMeasure> sensor) {
        super(sensor);
    }


}
