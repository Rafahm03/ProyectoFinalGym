package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {

	 @GetMapping("/login")
	    public String mostrarPaginaLogin(Model model) {
	        return "login"; 
	    }
	 
	 @GetMapping("/")
	 public String mostrarindice( Model model) {
		 return "index";	
		}
}
