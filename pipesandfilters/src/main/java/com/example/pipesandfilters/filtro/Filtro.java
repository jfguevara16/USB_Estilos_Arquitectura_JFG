package com.example.pipesandfilters.filtro;

import com.example.pipesandfilters.pipe.Pipe;

public interface Filtro <T> {
    void execute(T input, Pipe<T> output);

}
