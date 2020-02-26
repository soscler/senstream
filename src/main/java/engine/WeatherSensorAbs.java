package engine;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherSensorAbs extends SensorAbs implements Runnable, Generator<Measure>  {


    public WeatherSensorAbs(long id, double min, double max) {
        super(id, min, max);
    }

    public Measure generate(long seconds) throws InterruptedException {
        while (true) {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
            WeatherMeasure wdata = new WeatherMeasure(this);
            ThreadLocalRandom r = ThreadLocalRandom.current();
            double temperature = r.nextDouble(getMinValue(), getMaxValue());

            wdata.setDate(new Date());
            wdata.setMessage("Weather data");
            wdata.setValue(temperature);
            setMeasure(wdata);
            display();
        }
    }



    @Override
    public void run() {
        try {
            generate(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
