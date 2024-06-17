package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones.ExcepcionBorrarClase;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones.ExcepcionBorrarCuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones.ExcepcionBorrarPlan;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones.ExcepcionBorrarSocio;

@ControllerAdvice
public class ExcepcionesController {

	@ExceptionHandler(ExcepcionBorrarClase.class)
    public String handleExcepcionBorrarClase(Model model, ExcepcionBorrarClase ex) {
        model.addAttribute("mensajeError", ex.getMessage());
        return "excepcionbclase"; 
    }
	
	 @ExceptionHandler(ExcepcionBorrarSocio.class)
	    public String handleExcepcionBorrarCliente(Model model, ExcepcionBorrarSocio ex) {
	        model.addAttribute("mensajeError", ex.getMessage());
	        return "excepcionbsocio"; 
	    }
	 @ExceptionHandler(ExcepcionBorrarCuota.class)
	    public String handleExcepcionBorrarCliente(Model model, ExcepcionBorrarCuota ex) {
	        model.addAttribute("mensajeError", ex.getMessage());
	        return "excepcionbcuota"; 
	    }
	 
	 @ExceptionHandler(ExcepcionBorrarPlan.class)
	    public String handleExcepcionBorrarCliente(Model model, ExcepcionBorrarPlan ex) {
	        model.addAttribute("mensajeError", ex.getMessage());
	        return "excepcionbplan"; 
	    }
}
