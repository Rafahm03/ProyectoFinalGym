package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Plan;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.CuotaService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.PlanService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@Autowired
	private CuotaService cuotaService;
	
	@Autowired
	private SocioService socioService;
	
	@GetMapping("/planes")
	public String mostrarPlanes(Model model) {
		model.addAttribute("planes", planService.findAll());
		return "planes";
	}
	
	@PostMapping("/seleccionarPlan")
	public String seleccionarPlan(@AuthenticationPrincipal Socio socio, @RequestParam("planId") Long id, Model model) {
	    Optional<Plan> optionalPlan = planService.findById(id);
	    if (optionalPlan.isPresent()) {
	        Plan plan = optionalPlan.get();
	        socio.setPlan(plan);
	        socioService.save(socio);
	        model.addAttribute("id", socio.getId()); // Agregar el id al modelo
	        return "redirect:/suscripcion/" + socio.getId(); // Redirigir con el id del socio en la URL
	    } else {
	        model.addAttribute("error", "Plan no encontrado");
	        return "error";
	    }
	}


}
