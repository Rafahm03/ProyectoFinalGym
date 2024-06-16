package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Clase;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.ClaseRepositorio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.CuotaRepositorio;

@Service
public class ClaseService extends BaseServiceImpl<Clase, Long, ClaseRepositorio>{

	  @Autowired
	    private ClaseRepositorio claseRepositorio;

	    public List<Clase> findAll() {
	        return claseRepositorio.findAll();
	    }

	    public Optional<Clase> findById(Long id) {
	        return  claseRepositorio.findById(id);
	    }
	    
	    public List<Clase> findByNombre(String nombre) {
			return claseRepositorio.findByNombreContainingIgnoreCase(nombre);
		}
}
