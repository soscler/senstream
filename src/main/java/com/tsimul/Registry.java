package com.tsimul;

public interface Registry<T> {
    /*Holder<Double> get(String id) {
        return new Resolver();
    }*/

    Holder<T> get(String id);
}
