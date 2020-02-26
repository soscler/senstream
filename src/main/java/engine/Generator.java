package engine;

public interface Generator <T> {

    T generate(long seconds) throws InterruptedException;
}
