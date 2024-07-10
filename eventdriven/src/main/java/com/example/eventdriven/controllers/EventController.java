package com.example.eventdriven.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventdriven.eventos.EventoSimple;

@RestController
public class EventController {
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	@GetMapping("/publicar")
    public String publishEvent(@RequestParam String message) {
        EventoSimple event = new EventoSimple(message);
        eventPublisher.publishEvent(event);
        return "Evento publicado!";
    }

}
