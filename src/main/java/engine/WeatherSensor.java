package engine;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherSensor extends SensorAbs<WeatherMeasure> implements Runnable, Sensor<WeatherMeasure> {


    public WeatherSensor(long id, double min, double max, long freq) {
        super(id, min, max, freq);
    }

    /**
     * FIXME: Move the Thread run method to SensorAbs
     */
    @Override
    public void run() {
        try {
            start();
        } catch (InterruptedException | SensorException e) {
            e.printStackTrace();
        }
    }

    @Override
    public WeatherMeasure measure() throws SensorException {
        WeatherMeasure wdata = new WeatherMeasure(this);
        ThreadLocalRandom r = ThreadLocalRandom.current();
        double temperature = r.nextDouble(getMinValue(), getMaxValue());

        wdata.setDate(new Date());
        wdata.setMessage("Weather data");
        wdata.setValue(temperature);
        setMeasure(wdata);
        // display();
        return wdata;
    }
}
