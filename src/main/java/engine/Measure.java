package engine;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Measure {

    private Date date;
    private double value;
    private String message;
    private final SensorAbs sensorAbs;

    Measure(SensorAbs sensorAbs) {
        this.sensorAbs = sensorAbs;
    }

    @Override
    public String toString() {
        return "Date: " + date.toString() + "\nValue: " + value + "\nMessage: " + message;
    }
}
