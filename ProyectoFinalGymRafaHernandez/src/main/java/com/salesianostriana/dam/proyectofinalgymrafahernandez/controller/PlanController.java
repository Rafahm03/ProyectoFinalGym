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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Plan;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.CuotaService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.PlanService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@Autowired
	private CuotaService cuotaService;
	
	@Autowired
	private SocioService socioService;
	
	@GetMapping("/planes")
	public String mostrarPlanes(Model model) {
		model.addAttribute("planes", planService.findAll());
		return "planes";
	}
	
	@PostMapping("/seleccionarPlan")
	public String seleccionarPlan(@AuthenticationPrincipal Socio socio, @RequestParam("planId") Long id, Model model) {
	    Optional<Plan> optionalPlan = planService.findById(id);
	    if (optionalPlan.isPresent()) {
	        Plan plan = optionalPlan.get();
	        socio.setPlan(plan);
	        socioService.save(socio);
	        return "redirect:/suscripcion/" + socio.getId(); 
	    } else {
	        model.addAttribute("error", "Plan no encontrado");
	        return "error";
	    }
	}
	
	 @GetMapping("/admin/planes/lista")
	    public String listaPlanes(@RequestParam(name = "query", required = false) String query, Model model) {
	        if (query != null && !query.isEmpty()) {
	            model.addAttribute("planes", planService.findByNombre(query));
	        } else {
	            model.addAttribute("planes", planService.findAll());
	        }
	        return "planesAdmin";
	    }
	    
	    @PostMapping("/admin/planes/buscar")
	    public String buscarPlanes(@RequestParam("query") String query, RedirectAttributes redirectAttributes) {
	        redirectAttributes.addAttribute("query", query);
	        return "redirect:/admin/planes/lista";
	    }

	@GetMapping("/admin/plan/nuevo")
	public String mostrarFormularioPlan(Model model) {
		model.addAttribute("plan", new Plan());

		return "formularioPlanAdmin";
	}

	@PostMapping("admin/plan/nuevo/submit")
	public String guardarPlan(@ModelAttribute("plan") Plan plan, Model model) {
		planService.save(plan);
		return "redirect:/admin/planes/lista";//
	}

	@GetMapping("/admin/plan/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		Optional<Plan> aEditarOptional = planService.findById(id);

		if (aEditarOptional.isPresent()) {
			Plan aEditar = aEditarOptional.get();
			model.addAttribute("plan", aEditar);
			return "formularioPlanAdmin";
		} else {
			return "redirect:/admin/planes/lista";
		}
	}

	@PostMapping("/admin/plan/editar/submit")
	public String editPlanSubmit(@ModelAttribute("plan") Plan plan) {
		planService.edit(plan);
		return "redirect:/admin/planes/lista";
	}

	@GetMapping("/admin/plan/borrar/{id}")
	public String borrarPlan(@PathVariable("id") long id, Model model) {
		Optional<Plan> aBorrarOp = planService.findById(id);

		if (aBorrarOp.isPresent()) {
			Plan aBorrar = aBorrarOp.get();
			model.addAttribute("plan", aBorrar);
			planService.delete(aBorrar);
		}
		return "redirect:/admin/planes/lista";

	}//Hay que modificar el método para que si intenta borrar una cuota con un socio asociado,
	//salte una excepción.


}
