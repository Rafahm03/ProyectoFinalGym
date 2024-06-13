package com.salesianostriana.dam.proyectofinalgymrafahernandez.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Reserva;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.ReservaPK;

public interface ReservaRepositorio extends JpaRepository<Reserva, ReservaPK>{

}
