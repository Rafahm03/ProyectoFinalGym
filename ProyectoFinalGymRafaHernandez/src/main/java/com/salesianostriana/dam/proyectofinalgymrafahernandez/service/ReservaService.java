package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Reserva;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.ClaseColectivaRepositorio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.ReservaRepositorio;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.SocioRepositorio;

public class ReservaService extends BaseServiceImpl<Reserva, Long, ReservaRepositorio>{


    @Autowired
    private ClaseColectivaRepositorio claseColectivaRepositorio;

    @Autowired
    private SocioRepositorio socioRepositorio;

    @Autowired
    private ReservaRepositorio reservaRepositorio;
}
