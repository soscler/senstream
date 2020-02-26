package engine;

public interface Sensor <T extends Measure> {

    void on();
    T measure();
    void off();
    void display();

}
