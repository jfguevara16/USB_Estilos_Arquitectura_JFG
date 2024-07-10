package com.example.eventdriven.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.eventdriven.eventos.EventoSimple;

@Component
public class SimpleEventListener {
	
	@EventListener
    public void handleSimpleEvent(EventoSimple event) {
        System.out.println("Evento Recibido - " + event.getMensaje());
    }

}
