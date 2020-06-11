package com.tsimul.measure;

public interface Measure<T> {
    String toJson();
    T getValue();
}
