package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clases {

	@Id
	@GeneratedValue
	private Long id;
	
	private String img, nombre, descripcion, dias;

    private int capacidadMaxima;


}
