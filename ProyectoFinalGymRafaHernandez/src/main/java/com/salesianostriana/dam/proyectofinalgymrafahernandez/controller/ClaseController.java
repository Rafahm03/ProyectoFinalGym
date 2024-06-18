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

import com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones.ExcepcionBorrarClase;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Clase;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.ClaseService;

@Controller
public class ClaseController {

	@Autowired
	private ClaseService claseService;

	@GetMapping("/admin/clases/lista")
    public String listaClases(@RequestParam(name = "query", required = false) String query, Model model) {
        if (query != null && !query.isEmpty()) {
            model.addAttribute("clases", claseService.findByNombre(query));
        } else {
            model.addAttribute("clases", claseService.findAll());
        }
        return "clasesAdmin";
    }
    
    @PostMapping("/admin/clases/buscar")
    public String buscarClases(@RequestParam("query") String query, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("query", query);
        //El redirectAttributes almacena en un flashmap que utiliza internamente la sesión del usuario
        // para pasar estos datos a la siguiente redirección y elimina los datos que se utilizan.
        return "redirect:/admin/clases/lista";
    }
    
    @GetMapping("/admin/clases/nueva")
    public String mostrarFormularioClase(Model model) {
    	model.addAttribute("clase", new Clase());
    	return "formClaseAdmin";
    }
    
    @PostMapping("admin/clases/nuevo/submit")
	public String guardarClase(@ModelAttribute("clase") Clase clase, Model model) {
		claseService.save(clase);
		return "redirect:/admin/clases/lista";//
	}
    
    @GetMapping("/admin/clase/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
		Optional<Clase> aEditarOptional = claseService.findById(id);

		if (aEditarOptional.isPresent()) {
			Clase aEditar = aEditarOptional.get();
			model.addAttribute("clase", aEditar);
			return "formClaseAdmin";
		} else {
			return "redirect:/admin/clases/lista";
		}
	}

	@PostMapping("/admin/clase/editar/submit")
	public String editClaseSubmit(@ModelAttribute("clase") Clase clase) {
		claseService.edit(clase);
		return "redirect:/admin/clases/lista";
	}
	
	@GetMapping("/admin/clase/borrar/{id}")
	public String borrarClase(@PathVariable("id") long id, Model model) {
	    Optional<Clase> aBorrarOp = claseService.findById(id);
	    
	    if (aBorrarOp.isPresent()) {
	        Clase aBorrar = aBorrarOp.get();
	        if (aBorrar.getReservas()==null) {
	            claseService.delete(aBorrar);
	        } else {
	            throw new ExcepcionBorrarClase();
	        }
	    }
	    return "redirect:/admin/socios/lista";
	}
    
    
}
