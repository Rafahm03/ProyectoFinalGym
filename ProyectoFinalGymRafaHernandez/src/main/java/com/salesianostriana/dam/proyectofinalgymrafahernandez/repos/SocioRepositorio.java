package com.salesianostriana.dam.proyectofinalgymrafahernandez.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;

public interface SocioRepositorio 
	extends JpaRepository<Socio, Long>{
	
	public List<Socio> findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombre, String apellidos);

	
	Optional<Socio> findFirstByUsername(String username);
	
	@Query("select count(r) from Reserva r where r.socio = ?1")
	int countNumReservasBySocio(Socio socio);

}
