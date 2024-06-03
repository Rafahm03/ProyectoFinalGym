package com.salesianostriana.dam.proyectofinalgymrafahernandez.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;

public interface SocioRepositorio 
	extends JpaRepository<Socio, Long>{
	
	Optional<Socio> findFirstByUsername(String username);

}
