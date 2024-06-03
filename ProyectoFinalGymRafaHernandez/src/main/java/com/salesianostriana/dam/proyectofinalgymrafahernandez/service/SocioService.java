package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

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
        Socio user = new Socio();
        user.setUsername(socio.getUsername());
        
        // Encriptar la contraseña antes de guardarla
        String encodedPassword = passwordEncoder.encode(socio.getPassword());
        user.setPassword(encodedPassword);

       socioRepositorio.save(user);
    }

}
