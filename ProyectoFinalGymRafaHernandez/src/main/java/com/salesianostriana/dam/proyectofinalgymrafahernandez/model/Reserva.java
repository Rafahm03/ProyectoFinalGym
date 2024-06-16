package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;


import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

	@EmbeddedId
	private ReservaPK reservaPK = new ReservaPK();
	
	@ManyToOne
	@MapsId("socio_id")
	@JoinColumn(name = "socio_id")
	private Socio socio;

	@ManyToOne
	@MapsId("clase_id")
	@JoinColumn(name = "clase_id")
	private Clase clase;

	public void addToSocio(Socio s) {
		s.getReservas().add(this);
		this.socio = s;
	}

	public void removeFromSocio(Socio s) {
		s.getReservas().remove(this);
		this.socio = null;
	}
	
	
	public LocalDateTime getFechaReserva() {
        return this.reservaPK.getFecha_reserva();
    }

    public void setFechaReserva(LocalDateTime fecha_reserva) {
        this.reservaPK.setFecha_reserva(fecha_reserva);
    }

	

}
