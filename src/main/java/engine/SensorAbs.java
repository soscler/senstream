package engine;


import lombok.Data;

@Data
public abstract class SensorAbs {

    private final long id;
    private String name;
    private String location;
    private double minValue;
    private double maxValue;

    private Measure measure;

    SensorAbs(long id, double min, double max) {
        this.id = id;
        this.minValue = min;
        this.maxValue = max;
    }

    public void display() {
        System.out.println("Sensor: " + id);
        System.out.println(measure.toString());
    }


}
