package engine;

import java.io.Serializable;

public class WeatherMeasure extends Measure implements Serializable {

    public final static long serialVersionUID = 1234L;

    WeatherMeasure(SensorAbs sensorAbs) {
        super(sensorAbs);
    }


}
