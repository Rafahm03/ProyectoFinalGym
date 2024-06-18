package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Plan;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class PerfilController {

	@Autowired
	private SocioService socioService;


	 @GetMapping("/suscripcion/{id}")
	    public String mostrarSuscripcion(@PathVariable("id") Long id, Model model) {
	        Optional<Socio> socioOpt = socioService.findById(id);

	        if (socioOpt.isPresent()) {
	            Socio socio = socioOpt.get();
	            Cuota cuota = socio.getCuota();
	            Plan plan = socio.getPlan();

	            double precioCuota = (cuota != null) ? cuota.getPrecio() : 0.0;
	            double precioPlan = (plan != null) ? plan.getPrecio() : 0.0;

	            double precioFinalConDescuento = socioService.calcularDescuentoTotal(socio, precioCuota, precioPlan);
	            boolean descuentoFidelidad = socioService.esSocioFiel(socio);

	            String cuotaInfo = (cuota != null) ? "Cuota: " + cuota.getNombre() + " -> Precio: " + precioCuota : "No tiene cuota asignada.";
	            String planInfo = (plan != null) ? "Plan: " + plan.getNombre() + " -> Precio: " + precioPlan : "No tiene plan asignado.";

	            model.addAttribute("socio", socio);
	            model.addAttribute("cuota", cuotaInfo);
	            model.addAttribute("plan", planInfo);
	            model.addAttribute("precioFinal", precioFinalConDescuento);
	            model.addAttribute("descuentoFidelidad", descuentoFidelidad);

	            return "suscripcion";
	        } else {
	            model.addAttribute("error", "Socio no encontrado.");
	            return "error";
	        }
	    }
	@GetMapping("/miperfil")
	public String mostrarPerfilSocio(@AuthenticationPrincipal Socio socio, Model model) {
			model.addAttribute("socio", socio);
			socio.getReservas();
			return "perfil";
	}

}
