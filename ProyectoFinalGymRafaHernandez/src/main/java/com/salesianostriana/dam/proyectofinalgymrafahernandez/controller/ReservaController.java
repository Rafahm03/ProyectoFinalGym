package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;


import java.time.LocalDateTime;
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

	// Mostrar todas las clases disponibles
	@GetMapping("/clases")
	public String mostrarClases(Model model) {
		model.addAttribute("clases", clasesService.findAll());
		return "clases";
	}

	@PostMapping("/reservarclase")
	public String mostrarFormularioReserva(Model model) {
	    Reserva reserva = new Reserva();
	    ReservaPK reservaPK = new ReservaPK();
	    reservaPK.setClases_id(1L); // Ejemplo de asignación de clasesId
	    reserva.setReservaPK(reservaPK);
	    
	    model.addAttribute("reserva", reserva);
	    return "formReserva";
	}



	@PostMapping("/reservarclase/submit")
	public String createReserva(@AuthenticationPrincipal Socio socio,
	                            @RequestParam Long clasesId,
	                            @RequestParam("fecha_reserva") LocalDateTime fecha_reserva) {
	    Optional<Clases> clasesOpt = clasesService.findById(clasesId);

	    if (clasesOpt.isPresent()) {
	        ReservaPK reservaPK = new ReservaPK();
	        reservaPK.setSocio_id(socio.getId());
	        reservaPK.setClases_id(clasesId);
	        reservaPK.setFecha_reserva(fecha_reserva);


	        Reserva reserva = new Reserva();
	        reserva.setReservaPK(reservaPK);
	        reserva.setNombreSolicitante(socio.getNombre());
	        reserva.setSocio(socio);
	        reserva.setClases(clasesOpt.get());

	        reservaService.save(reserva);
	        return "panelReserva";
	    } else {
	        return "formularioReserva";
	    }
	}



}
