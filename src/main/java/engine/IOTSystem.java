package engine;

/**
 * An IOT System is a system composed of multiple sensor
 */
public interface IOTSystem {

    /**
     * Turn on the system
     * This will try to turn on all the sensors inside the system
     */
    public void start();

    /**
     * Turn off the system
     * This will try to turn off all the sensors inside the system
     */
    public void stop();
}
