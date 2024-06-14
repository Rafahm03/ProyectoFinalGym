package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Clase;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Reserva;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.ClaseService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.ReservaService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class ReservaController {

    @Autowired
    private ClaseService claseService;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private SocioService socioService;

    @GetMapping("/clases")
    public String mostrarClases(Model model) {
        model.addAttribute("clases", claseService.findAll());
        return "clases";
    }

    @GetMapping("/reservarclase/{clase_id}")
    public String mostrarFormularioReserva(Model model, @PathVariable("clase_id") long clase_id) {
        model.addAttribute("socios", socioService.findAll());
        model.addAttribute("clase", claseService.findById(clase_id));  

        Reserva reserva = new Reserva();
        model.addAttribute("reserva", reserva);
        return "formReserva";
    }

    @PostMapping("/reservarclase/submit")
    public String createReserva(@AuthenticationPrincipal Socio socio, @ModelAttribute("reserva") Reserva reserva,
                                @RequestParam("clase_id") Long id) {  

        Optional<Clase> claseOpt = claseService.findById(id);
        if (claseOpt.isPresent()) {
			Clase clase = claseOpt.get();

            reserva.setClase(clase);

        reserva.addToSocio(socio);

        reservaService.save(reserva);

        } return "redirect:/panelReserva";
    }

    @GetMapping("/panelReserva")
    public String mostrarPanelReserva(Model model) {
        return "panelReserva";
    }
}

