package com.salesianostriana.dam.proyectofinalgymrafahernandez.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;

public interface CuotaRepositorio extends JpaRepository<Cuota, Long> {

	public List<Cuota> findByNombreContainingIgnoreCase(String nombre);

}
