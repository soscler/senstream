package com.tsimul.measure;

public interface Measure {
    String toJson();
    void resolve(Double value);
}
