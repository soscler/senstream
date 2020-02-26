package engine;


/**
 * Can be used for artificial sensors (like the ones we are simulating here
 * A real sensor does not generate data, it measure or read the data
 * An artificial sensor can generate data
 * @param <T>
 */
public interface Generator <T> {
    T generate(long seconds) throws InterruptedException;
}
