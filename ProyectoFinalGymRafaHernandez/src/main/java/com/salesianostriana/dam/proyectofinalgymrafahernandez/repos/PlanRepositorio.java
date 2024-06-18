package com.salesianostriana.dam.proyectofinalgymrafahernandez.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Plan;

public interface PlanRepositorio extends JpaRepository<Plan, Long>{

	public List<Plan> findByNombreContainingIgnoreCase(String nombre);

}
