package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.CuotaService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.PlanService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;
import org.springframework.ui.Model;


@Controller
public class PerfilController {

	@Autowired
    private SocioService socioService;
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private CuotaService cuotaService;
	
	@GetMapping("/suscripcion/{id}")
	public String mostrarSuscripcion(@PathVariable Long id, Model model) {
	    Optional<Socio> socioOpt = socioService.findById(id);

	    if (socioOpt.isPresent()) {
	        Socio socio = socioOpt.get();
	        String cuota = Optional.ofNullable(socio.getCuota())
	                               .map(c -> "Cuota: " + c.getNombre() + " -> Precio: " + c.getPrecio())
	                               .orElse("No tiene cuota asignada.");

	        String plan = Optional.ofNullable(socio.getPlan())
	                              .map(p -> "Plan: " + p.getNombre() + " -> Precio: " + p.getPrecio())
	                              .orElse("No tiene plan asignado.");

	        model.addAttribute("socio", socio);
	        model.addAttribute("cuota", cuota);
	        model.addAttribute("plan", plan);   

	        return "perfil"; 
	    } else {
	        return "Socio no encontrado.";
	    }
	}




}
