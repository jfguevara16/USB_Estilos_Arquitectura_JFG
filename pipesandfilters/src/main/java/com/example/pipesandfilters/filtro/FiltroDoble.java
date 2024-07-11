package com.example.pipesandfilters.filtro;

import org.springframework.stereotype.Component;

import com.example.pipesandfilters.pipe.Pipe;

@Component
public class FiltroDoble implements Filtro<Integer> {
	@Override
    public void execute(Integer input, Pipe<Integer> output) {
        output.process(input * 2);
    }

}
