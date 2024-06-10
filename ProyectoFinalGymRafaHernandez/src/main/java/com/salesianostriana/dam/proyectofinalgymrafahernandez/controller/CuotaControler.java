package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.CuotaService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class CuotaControler {
	@Autowired
	private CuotaService cuotaService;

	@Autowired
	private SocioService socioService;
	
	

	@GetMapping("/cuotas")
	public String mostrarCuotas(Model model) {
		model.addAttribute("cuotas", cuotaService.findAll());
		return "cuotas";
	}

	@PostMapping("/seleccionarCuota")
	public String seleccionarCuota(@AuthenticationPrincipal Socio socio, @RequestParam("cuotaId") Long id, Model model) {
	    Optional<Cuota> optionalCuota = cuotaService.findById(id);
	    if (optionalCuota.isPresent()) {
	        Cuota cuota = optionalCuota.get();
	        socio.setCuota(cuota);
	        socioService.save(socio);
	        return "redirect:/planes";
	    } else {
	        model.addAttribute("error", "Cuota no encontrada");
	        return "error";
	    }
	}

	
	
}
