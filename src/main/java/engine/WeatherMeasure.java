package engine;

import java.io.Serializable;

public class WeatherMeasure extends MeasureAbs implements Serializable, Measure {

    public final static long serialVersionUID = 1234L;

    WeatherMeasure(Sensor<WeatherMeasure> sensor) {
        super(sensor);
    }


}
