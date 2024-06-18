package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import java.time.LocalDate;
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

	
    private static final double DESCUENTO_POR_FIDELIDAD = 0.10; //un descuento para los socios que tengan mas de un anio :)

	
	public void registerNewSocio(Socio socio) {
	    
	    socio.setPassword(passwordEncoder.encode(socio.getPassword()));
	    
	    socioRepositorio.save(socio);
	}
	
	public List<Socio> findByNombreYApellidos(String nombre, String apellidos) {
		return socioRepositorio.findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(nombre, apellidos);
	}
	

    public double calcularDescuentoTotal(Socio socio, double precioCuota, double precioPlan) {
        double totalOriginal = precioCuota + precioPlan;
        if (esSocioFiel(socio)) {
            return totalOriginal * (1 - DESCUENTO_POR_FIDELIDAD);
        } else {
            return totalOriginal;
        }
    }

    
    public boolean esSocioFiel(Socio socio) {
        LocalDate fechaAlta = socio.getFecha_alta();
        LocalDate fechaLimite = LocalDate.now().minusYears(1);//pongo como fehca limite un anio
        return fechaAlta.isBefore(fechaLimite);
    }

    public double calcularTotalInscripciones() {
        List<Socio> socios = socioRepositorio.findAll();
        double total = 0.0;

        for (Socio socio : socios) {
            total += socio.getInscripcion();
        }

        return total;
    }
}
