package com.example.p2p;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class Controlador {
	
	private final List<Mensaje> messages = new ArrayList<>();

    @PostMapping("/send")
    public void sendMessage(@RequestBody Mensaje message) {
        System.out.println("Received message: " + message.getContent() + " from: " + message.getFrom());
        messages.add(message);
    }

    @GetMapping("/receive")
    public List<Mensaje> receiveMessages() {
        return messages;
    }

}
