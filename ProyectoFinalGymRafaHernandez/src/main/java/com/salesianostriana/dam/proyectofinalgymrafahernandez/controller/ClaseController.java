package com.salesianostriana.dam.proyectofinalgymrafahernandez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.ClaseService;

@Controller
public class ClaseController {

	@Autowired
	private ClaseService clasService;

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
        return "redirect:/admin/clases/lista";
    }
}
