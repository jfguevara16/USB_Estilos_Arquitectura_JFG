package com.example.agentbased;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Agent implements Runnable {
	
	private String id;
    private String name;
    private BlockingQueue<String> messageQueue;
    private boolean active;

    public Agent(String id, String name) {
        this.id = id;
        this.name = name;
        this.messageQueue = new LinkedBlockingQueue<>();
        this.active = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        messageQueue.add(message);
    }

    public void stop() {
        active = false;
    }

    @Override
    public void run() {
        while (active) {
            try {
                String message = messageQueue.take();
                processMessage(message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void processMessage(String message) {
        System.out.println("Agent " + name + " mensaje recibido: " + message);
    }

}
