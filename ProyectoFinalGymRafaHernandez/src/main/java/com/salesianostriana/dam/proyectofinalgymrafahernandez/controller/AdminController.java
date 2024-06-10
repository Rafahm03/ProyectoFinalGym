package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@GetMapping("/general")
	public String mostrarVistaGeneral(Model model) {
		return "general";
	}
	
}