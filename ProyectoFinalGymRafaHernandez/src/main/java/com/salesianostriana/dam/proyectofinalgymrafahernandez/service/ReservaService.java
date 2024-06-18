package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Reserva;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.ReservaPK;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Socio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.ReservaRepositorio;

@Service
public class ReservaService extends BaseServiceImpl<Reserva, ReservaPK, ReservaRepositorio>{


    @Autowired
    private ReservaRepositorio reservaRepositorio;
    
    public List<Reserva> findBySocio(Socio socio) {
        return reservaRepositorio.findBySocio(socio);
    }
    
   
}
