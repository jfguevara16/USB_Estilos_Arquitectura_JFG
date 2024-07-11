package com.example.pipesandfilters.pipe;

public interface Pipe<T> {
    void process(T input);
}
