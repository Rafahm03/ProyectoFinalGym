package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Embeddable
public class ReservaPK implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	 private long socio_id;
	 private long clases_id;
	 
	 @Column(name = "fecha_reserva")
	    private LocalDateTime fecha_reserva;
	 
	
}
