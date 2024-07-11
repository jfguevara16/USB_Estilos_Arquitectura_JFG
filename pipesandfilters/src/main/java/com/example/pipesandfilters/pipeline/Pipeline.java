package com.example.pipesandfilters.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.pipesandfilters.filtro.Filtro;
import com.example.pipesandfilters.pipe.Pipe;

@Component
public class Pipeline implements Pipe<Integer> {
	
	private final List<Filtro<Integer>> filtros = new ArrayList<>();
    private final List<Integer> salida = new ArrayList<>();
    
    public void addFilter(Filtro<Integer> filter) {
        filtros.add(filter);
    }

    public List<Integer> getOutput() {
        return salida;
    }

    @Override
    public void process(Integer input) {
    	executeFilters(input, 0);
    }
    
    private void executeFilters(Integer input, int index) {
        if (index < filtros.size()) {
        	Filtro<Integer> filter = filtros.get(index);
            filter.execute(input, (processedInput) -> executeFilters(processedInput, index + 1));
        } else {
        	salida.add(input);
        }
    }

}
