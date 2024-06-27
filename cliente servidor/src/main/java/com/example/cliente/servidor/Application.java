package com.example.cliente.servidor;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.cliente.servidor.cliente.Cliente;
import com.example.cliente.servidor.server.Server;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// Start the server
        new Thread(() -> {
            try {
                Server server = new Server();
                server.start(6666);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Give the server a moment to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the client
        Cliente client = new Cliente();
        try {
            client.startConnection("127.0.0.1", 6666);
            String response = client.sendMessage("hello server");
            System.out.println("Server response: " + response);

            response = client.sendMessage("bye");
            System.out.println("Server response: " + response);

            client.stopConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	}
