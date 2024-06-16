package com.salesianostriana.dam.proyectofinalgymrafahernandez.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Clase;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;

public interface ClaseRepositorio extends JpaRepository<Clase, Long> {

	public List<Clase> findByNombreContainingIgnoreCase(String nombre);

}
