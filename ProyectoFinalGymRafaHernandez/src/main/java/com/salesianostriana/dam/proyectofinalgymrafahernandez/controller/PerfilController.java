package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Plan;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Reserva;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.CuotaService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.PlanService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;


@Controller
public class PerfilController {

	@Autowired
    private SocioService socioService;
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private CuotaService cuotaService;
	
	@GetMapping("/suscripcion/{id}")
	public String mostrarSuscripcion(@PathVariable("id") Long id, Model model) {
	    Optional<Socio> socioOpt = socioService.findById(id);

	    if (socioOpt.isPresent()) {
	        Socio socio = socioOpt.get();
	        Cuota cuota = socio.getCuota();
	        Plan plan = socio.getPlan();

	        String cuotaInfo = (cuota != null) ? 
	            "Cuota: " + cuota.getNombre() + " -> Precio: " + cuota.getPrecio() :
	            "No tiene cuota asignada.";

	        String planInfo = (plan != null) ? 
	            "Plan: " + plan.getNombre() + " -> Precio: " + plan.getPrecio() :
	            "No tiene plan asignado.";

	        model.addAttribute("socio", socio);
	        model.addAttribute("cuota", cuotaInfo);
	        model.addAttribute("plan", planInfo);   

	        return "perfil"; 
	    } else {
	        model.addAttribute("error", "Socio no encontrado.");
	        return "error"; 
	    }
	}

}
