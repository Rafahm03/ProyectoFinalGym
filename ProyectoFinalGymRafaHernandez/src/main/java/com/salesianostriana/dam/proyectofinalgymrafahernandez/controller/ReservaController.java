package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Clases;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Reserva;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.ReservaPK;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.ClasesService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.ReservaService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class ReservaController {

	@Autowired
	private ClasesService clasesService;

	@Autowired
	private ReservaService reservaService;

	@Autowired
	private SocioService socioService;

	@GetMapping("/clases")
	public String mostrarCuotas(Model model) {
		model.addAttribute("clases", clasesService.findAll());
		return "clases";
	}

	@PostMapping("/seleccionarClase")
	public String seleccionarClase(@AuthenticationPrincipal Socio socio, @RequestParam("reservaId") ReservaPK id,
			Model model) {
		Optional<Reserva> optionalReserva = reservaService.findById(id);
		if (optionalReserva.isPresent()) {
			Reserva reserva = optionalReserva.get();
			reserva.addToSocio(socio);
			socioService.save(socio);
			return "redirect:/panelReserva";
		} else {
			model.addAttribute("error", "Clase no encontrada");
			return "error";
		}
	}

}
