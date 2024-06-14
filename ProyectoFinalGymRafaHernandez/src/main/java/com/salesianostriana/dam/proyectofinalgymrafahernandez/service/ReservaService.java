package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Reserva;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.ReservaPK;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.ClaseRepositorio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.ReservaRepositorio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.SocioRepositorio;
@Service
public class ReservaService extends BaseServiceImpl<Reserva, ReservaPK, ReservaRepositorio>{


    @Autowired
    private ClaseRepositorio clasesRepositorio;

    @Autowired
    private SocioRepositorio socioRepositorio;

    @Autowired
    private ReservaRepositorio reservaRepositorio;
    
    
    
}
