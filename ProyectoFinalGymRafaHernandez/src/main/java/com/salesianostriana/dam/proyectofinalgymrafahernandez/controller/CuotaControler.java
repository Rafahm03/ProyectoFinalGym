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

import com.salesianostriana.dam.proyectofinalgymrafahernandez.excepciones.ExcepcionBorrarCuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.CuotaService;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.service.SocioService;

@Controller
public class CuotaControler {
	@Autowired
	private CuotaService cuotaService;

	@Autowired
	private SocioService socioService;

	@GetMapping("/cuotas")
	public String mostrarCuotas(Model model) {
		model.addAttribute("cuotas", cuotaService.findAll());
		return "cuotas";
	}

	@PostMapping("/seleccionarCuota")
	public String seleccionarCuota(@AuthenticationPrincipal Socio socio, @RequestParam("cuotaId") Long id,
			Model model) {
		Optional<Cuota> optionalCuota = cuotaService.findById(id);
		if (optionalCuota.isPresent()) {
			Cuota cuota = optionalCuota.get();
			socio.setCuota(cuota);
			socioService.save(socio);
			return "redirect:/planes";
		} else {
			model.addAttribute("error", "Cuota no encontrada");
			return "error";
		}
	}
	
	@GetMapping("/admin/cuotas/lista")
    public String listaCuotas(@RequestParam(name = "query", required = false) String query, Model model) {
        if (query != null && !query.isEmpty()) {
            model.addAttribute("cuotas", cuotaService.findByNombre(query));
        } else {
            model.addAttribute("cuotas", cuotaService.findAll());
        }
        return "cuotasAdmin";
    }
    
    @PostMapping("/admin/cuotas/buscar")
    public String buscarCuotas(@RequestParam("query") String query, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("query", query);
        return "redirect:/admin/cuotas/lista";
    }

	@GetMapping("/admin/cuota/nuevo")
	public String mostrarFormularioCuota(Model model) {
		model.addAttribute("cuota", new Cuota());

		return "formularioCuotaAdmin";
	}

	@PostMapping("admin/cuota/nuevo/submit")
	public String guardarCuota(@ModelAttribute("cuota") Cuota cuota, Model model) {
		cuotaService.save(cuota);
		return "redirect:/admin/cuotas/lista";//
	}

	@GetMapping("/admin/cuota/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
		Optional<Cuota> aEditarOptional = cuotaService.findById(id);

		if (aEditarOptional.isPresent()) {
			Cuota aEditar = aEditarOptional.get();
			model.addAttribute("cuota", aEditar);
			return "formularioCuotaAdmin";
		} else {
			return "redirect:/admin/cuotas/lista";
		}
	}

	@PostMapping("/admin/cuota/editar/submit")
	public String editCuotaSubmit(@ModelAttribute("cuota") Cuota cuota) {
		cuotaService.edit(cuota);
		return "redirect:/admin/cuotas/lista";
	}

	@GetMapping("/admin/cuota/borrar/{id}")
	public String borrarCuota(@PathVariable("id") Long id, Model model) {
		Optional<Cuota> aBorrarOp = cuotaService.findById(id);

		if (aBorrarOp.isPresent()) {
			Cuota aBorrar = aBorrarOp.get();
			if (aBorrar.getSocios()==null && aBorrar.getPlan()==null ) {
	            cuotaService.delete(aBorrar);
	        } else {
	            throw new ExcepcionBorrarCuota();
	        }
	    }
	    return "redirect:/admin/cuotas/lista";
	}


}
