package com.tsimul;

import java.util.function.Consumer;

/**
 * There is name conflict with Observable
 * TODO: Review naming
 * @param <T>
 */
@FunctionalInterface
public interface Holder<T> {
    void subscribe(Consumer<T> c);
}
