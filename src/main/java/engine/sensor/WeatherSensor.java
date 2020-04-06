package engine.sensor;

import engine.generator.FrequencyGenerator;
import engine.measure.WeatherMeasure;

public class WeatherSensor extends SensorAbs<WeatherMeasure> {


    public WeatherSensor(long id, double min, double max, long freq) {
        super(id, min, max, freq);
        WeatherMeasure measure = new WeatherMeasure(this);
        this.setMeasure(measure);
    }

    public WeatherSensor(long id, FrequencyGenerator<Double> generator) {
        super(id, generator);
        WeatherMeasure measure = new WeatherMeasure(this);
        this.setMeasure(measure);
    }

}
