package engine.measure;

import engine.sensor.Sensor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class MeasureAbs implements Measure {

    private Date date;
    private double value;
    private String message;
    private final Sensor sensor;


    MeasureAbs(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Date: " + date.toString() + "\nValue: " + value + "\nMessage: " + message;
    }

    @Override
    public String toJson() {
        return "{ 'date': " + date + ", value: " + value + ", message: " + message + "}";
    }
}
