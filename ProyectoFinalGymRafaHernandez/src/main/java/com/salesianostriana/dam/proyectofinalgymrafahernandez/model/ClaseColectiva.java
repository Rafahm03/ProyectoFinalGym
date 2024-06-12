package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaseColectiva {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre, descripcion;
	
	 @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	    private LocalDateTime horario;

    private int capacidadMaxima;
    
    @OneToMany(mappedBy = "claseColectiva")
    private List<Reserva> reservas;

    public boolean estaCompleta() {
        return reservas != null && reservas.size() >= capacidadMaxima;
    }

}
