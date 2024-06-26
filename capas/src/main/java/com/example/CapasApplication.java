package com.example;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.controller.UserController;
import com.example.model.User;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CapasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapasApplication.class, args);
		UserController userController = new UserController();
		// Create a new user
        User newUser = new User("1", "Juan Felipe Guevara", "juan.guevara@example.com");
        userController.saveUser(newUser);
        
        User newUser2 = new User("2", "Juan Diego Galindo", "juan.diego@example.com");
        userController.saveUser(newUser2);
        
        Scanner sc= new Scanner(System.in);
        boolean condicionDeAlto=true;
        boolean condicionMensaje=true;
        while(condicionDeAlto) {
        	if(condicionMensaje) {
        		System.out.println("Ingresa el id de tu usuario: ");
                condicionMensaje=false;
        	}
        	String id =sc.next();
        	if(esNumero(id)) {
        		User retrievedUser = userController.getUserById(id);
                System.out.println("Datos del usuaio: " + retrievedUser.getName() + ", " + retrievedUser.getEmail());
                condicionDeAlto=false;
        		
        	}else {
        		System.out.println("Digitaste algo que no es un número, por favor intenta de nuevo ");
        		condicionMensaje=true;
        	}
        	
        }

	}
	
	public static boolean esNumero(String id){
		boolean esNumero=true;
		try {
            Integer.parseInt(id);
            esNumero = true;
        } catch (NumberFormatException excepcion) {
        	esNumero = false;
        }
		return esNumero;
	}

}
