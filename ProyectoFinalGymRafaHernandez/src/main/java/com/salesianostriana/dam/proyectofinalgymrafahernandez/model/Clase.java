package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clase {

	@Id
	@GeneratedValue
	private Long id;
	
	private String img, nombre, descripcion, dias;

    private int capacidadMaxima;
    
    @OneToMany(mappedBy="clase", fetch = FetchType.EAGER)
   	@Builder.Default
   	@EqualsAndHashCode.Exclude
   	@ToString.Exclude
   	private List<Reserva> reservas = new ArrayList<>();

    public void addReserva (Reserva r) {
    	reservas.add(r);
    	r.setClase(this);
    }

    public void removeReserva (Reserva r) {
    	reservas.remove(r);
    	r.setClase(this);
    }
}
