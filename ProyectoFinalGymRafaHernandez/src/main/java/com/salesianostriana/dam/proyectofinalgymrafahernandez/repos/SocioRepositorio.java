package com.salesianostriana.dam.proyectofinalgymrafahernandez.repos;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 8d600514ceba6530efa76369b3f084523c28dbc4
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;

public interface SocioRepositorio 
	extends JpaRepository<Socio, Long>{
	
<<<<<<< HEAD
	public List<Socio> findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombre, String apellidos);

	
=======
>>>>>>> 8d600514ceba6530efa76369b3f084523c28dbc4
	Optional<Socio> findFirstByUsername(String username);

}
