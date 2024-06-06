package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.SocioRepositorio;

@Service
public class SocioService extends BaseServiceImpl<Socio, Long, SocioRepositorio>{

	@Autowired
	private SocioRepositorio socioRepositorio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void registerNewSocio(Socio socio) {
	    
	    socio.setPassword(passwordEncoder.encode(socio.getPassword()));
	    
	    socioRepositorio.save(socio);
	}
	
	public List<Socio> findByNombreYApellidos(String nombre, String apellidos) {
		return socioRepositorio.findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(nombre, apellidos);
	}
	

}
