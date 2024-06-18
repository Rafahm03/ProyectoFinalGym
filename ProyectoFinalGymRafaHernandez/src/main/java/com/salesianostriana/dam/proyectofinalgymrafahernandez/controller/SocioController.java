package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones.ExcepcionBorrarSocio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class SocioController {

	 @Autowired
	    private SocioService socioService;
	 
	 
	    
	    @GetMapping("/admin/socios/lista")
	    public String listaSocios(@RequestParam(name = "query", required = false) String query, Model model) {
	        if (query != null && !query.isEmpty()) {
	            model.addAttribute("socios", socioService.findByNombreYApellidos(query, query));
	        } else {
	            model.addAttribute("socios", socioService.findAll());
	        }
	        return "socios";
	    }
	    
	    @PostMapping("/admin/socios/buscar")
	    public String buscarSocios(@RequestParam("query") String query, RedirectAttributes redirectAttributes) {
	        redirectAttributes.addAttribute("query", query);
	        return "redirect:/admin/socios/lista";
	    }
	        
	    @GetMapping("/admin/socio/nuevo")
		public String mostrarFormularioSocio(Model model) {
			model.addAttribute("socio", new Socio());

			return "formularioSocioAdmin";
		}
		
		@PostMapping("admin/socio/nuevo/submit")
		public String guardarcliente(@ModelAttribute("socio") Socio socio, Model model) {
			socioService.registerNewSocio(socio);
			return "redirect:/admin/socios/lista";//
		}
		
	    
	    @GetMapping("/admin/socio/editar/{id}")
		public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
			Optional<Socio> aEditarOptional = socioService.findById(id);
			
			if (aEditarOptional.isPresent()) {
				Socio aEditar = aEditarOptional.get();
				model.addAttribute("socio", aEditar);
				return "formularioSocioAdmin";
			} else {
				return "redirect:/admin/socios/lista";
			}
	    }
		

		@PostMapping("/admin/socio/editar/submit")
		public String editSocioSubmit(@ModelAttribute("socio") Socio socio) {
			socioService.edit(socio);
			return "redirect:/admin/socios/lista";
		}
		
		@GetMapping("/admin/socio/borrar/{id}")
		public String borrarSocio(@PathVariable("id") long id, Model model) {
		    Optional<Socio> aBorrarOp = socioService.findById(id);
		    
		    if (aBorrarOp.isPresent()) {
		        Socio aBorrar = aBorrarOp.get();
		        if (aBorrar.getCuota() != null && aBorrar.getPlan() !=null && aBorrar.getReservas()!=null) {
		            throw new ExcepcionBorrarSocio();
		        } else {
		            socioService.delete(aBorrar);

		        }
		    }
		    return "redirect:/admin/socios/lista";
		}


}
