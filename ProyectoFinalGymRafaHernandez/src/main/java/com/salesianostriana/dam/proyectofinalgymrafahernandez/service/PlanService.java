package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Plan;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.PlanRepositorio;

@Service
public class PlanService extends BaseServiceImpl<Plan, Long, PlanRepositorio>{

	@Autowired
    private PlanRepositorio planRepositorio;

    public List<Plan> findAll() {
        return planRepositorio.findAll();
    }

    public Optional<Plan> findById(Long id) {
        return planRepositorio.findById(id);
    }
    
    public List<Plan> findByNombre(String nombre) {
		return planRepositorio.findByNombreContainingIgnoreCase(nombre);
	}
}
