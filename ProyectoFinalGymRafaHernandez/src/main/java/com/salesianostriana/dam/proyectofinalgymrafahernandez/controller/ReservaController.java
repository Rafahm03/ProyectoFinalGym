package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Clase;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Reserva;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.ReservaPK;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.ClaseService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.ReservaService;

@Controller
public class ReservaController {

    @Autowired
    private ClaseService claseService;

    @Autowired
    private ReservaService reservaService;


    @GetMapping("/clases")
    public String mostrarClases(Model model) {
        model.addAttribute("clases", claseService.findAll());
        return "clases";
    }

    // Mostrar el formulario de reserva para una clase elegida por el socio
    @GetMapping("/reservarclase/{clase_id}")
    public String mostrarFormularioReserva(@AuthenticationPrincipal Socio socio, Model model, @PathVariable("clase_id") Long clase_id) {
        model.addAttribute("socio", socio);
        Optional<Clase> claseOpt = claseService.findById(clase_id);
        if (claseOpt.isPresent()) {
            Clase clase = claseOpt.get();
            model.addAttribute("clase", clase);
            Reserva reserva = new Reserva();
            reserva.setReservaPK(new ReservaPK()); 
            model.addAttribute("reserva", reserva);
            return "formReserva";
        } else {
            model.addAttribute("error", "Clase no encontrada.");
            return "error";
        }
    }

    // Crear la reserva para la clase seleccionada
    @PostMapping("/reservarclase/submit")
    public String createReserva(@AuthenticationPrincipal Socio socio,
                                @RequestParam("clase_id") Long clase_id,
                                @RequestParam("fecha_reserva") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha_reserva,
                                @ModelAttribute("reserva") Reserva reserva, Model model) {

        Optional<Clase> claseOpt = claseService.findById(clase_id);
        if (claseOpt.isPresent()) {
            Clase clase = claseOpt.get();
            ReservaPK reservaPK = new ReservaPK();
            reservaPK.setSocio_id(socio.getId());
            reservaPK.setClase_id(clase.getId());
            reservaPK.setFecha_reserva(fecha_reserva); // Usar la fecha elegida por el socio
            reserva.setReservaPK(reservaPK);

            reserva.setSocio(socio);
            reserva.setClase(clase);

            reservaService.save(reserva);

            return "redirect:/panelReserva/" + socio.getId();
        } else {
            model.addAttribute("error", "Clase no encontrada.");
            return "error";
        }
    }

 
    @GetMapping("/panelReserva/{id}")
    public String mostrarPanelReserva(@AuthenticationPrincipal Socio socio, @PathVariable("id") Long id, Model model) {
        model.addAttribute("reservas", reservaService.findBySocio(socio));
        return "panelReserva";
    }
}

