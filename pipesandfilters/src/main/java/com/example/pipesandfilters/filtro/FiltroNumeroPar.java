package com.example.pipesandfilters.filtro;

import org.springframework.stereotype.Component;

import com.example.pipesandfilters.pipe.Pipe;

@Component
public class FiltroNumeroPar implements Filtro<Integer> {
	
	@Override
    public void execute(Integer input, Pipe<Integer> output) {
        if (input % 2 == 0) {
            output.process(input);
        }
    }

}
