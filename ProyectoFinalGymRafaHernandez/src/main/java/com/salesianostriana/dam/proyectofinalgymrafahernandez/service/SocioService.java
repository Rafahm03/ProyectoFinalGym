package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Plan;
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
	
	 public double calcularCostoTotalSuscripcion(Long socioId) {
	        Optional<Socio> socioOpt = socioRepositorio.findById(socioId);

	        if (socioOpt.isPresent()) {
	            Socio socio = socioOpt.get();

	            double costoCuota = Optional.ofNullable(socio.getCuota())
	                                        .map(Cuota::getPrecio)
	                                        .orElse(0.0);

	            double costoPlan = Optional.ofNullable(socio.getPlan())
	                                       .map(Plan::getPrecio)
	                                       .orElse(0.0);

	            return costoCuota + costoPlan;
	        } else {
	            // Manejar el caso en que el socio no se encuentre, podría lanzar una excepción
	            throw new NoSuchElementException("Socio no encontrado con ID: " + socioId);
	        }
	    }
}
