package engine.measure;

public interface Measure {
    String toJson();
    void resolve(Double value);
}
