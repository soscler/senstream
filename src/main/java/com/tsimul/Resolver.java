package com.tsimul;

import java.util.function.Consumer;

public class Resolver implements Holder<Double> {

    @Override
    public void subscribe(Consumer<Double> c) {
        // Do the computation here
        c.accept(5.0);
    }
}
