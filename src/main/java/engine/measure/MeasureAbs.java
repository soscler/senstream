package engine.measure;

import engine.sensor.Sensor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class MeasureAbs<T extends Measure> implements Measure {

    private Date date;
    private Double value;
    private String message;
    private final Sensor<T> sensor;

    protected MeasureAbs(Sensor<T> sensor) {
        this.sensor = sensor;
    }

    @Override
    public void resolve(Double value) {
        this.value = value;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Date: " + date + "\nValue: " + value + "\nMessage: " + message;
    }

    @Override
    public String toJson() {
        return "{ 'date': " + date + ", value: " + value + ", message: " + message + "}";
    }
}
