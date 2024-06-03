package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class MainController {

	@Autowired
	private SocioService socioService;
	
	 @GetMapping("/login")
	    public String mostrarPaginaLogin(Model model) {
	        return "login"; 
	    }
	 
	 @GetMapping("/")
	 public String mostrarindice( Model model) {
		 return "index";	
		}
	 
	 @GetMapping("/registro")
	 public String mostrarRegistroSocio(Model model) {
		    model.addAttribute("socio", new Socio());
		 return "formSocio";
	 }
	 
	 @GetMapping("/socio/nuevo")
		public String mostrarFormularioRegistroCliente(Model model) {
			model.addAttribute("socio", new Socio());

			return "formSocio";
		}
		
		@PostMapping("/socio/nuevo/submit")
		public String guardarNuevoSocio(@ModelAttribute("socio") Socio socio, Model model) {
			
			socioService.registerNewSocio(socio);
			return "redirect:/login";
		}

}
