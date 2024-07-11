package com.example.pipesandfilters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pipesandfilters.filtro.FiltroDoble;
import com.example.pipesandfilters.filtro.FiltroNumeroPar;
import com.example.pipesandfilters.pipeline.Pipeline;

@RestController
public class Procesador {
	
	@Autowired
    private FiltroDoble filtroDoble;

    @Autowired
    private FiltroNumeroPar filtroDeNumerosPares;

    @Autowired
    private Pipeline pipeline;

    @GetMapping("/procesar")
    public List<Integer> processNumbers(@RequestParam List<Integer> numbers) {
        pipeline.addFilter(filtroDoble);
        pipeline.addFilter(filtroDeNumerosPares);

        for (Integer number : numbers) {
            pipeline.process(number);
        }

        return pipeline.getOutput();
    }

}
