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
public class Plan {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre, descripcion;
	
	private double precio;
	

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="plan", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Socio> socios = new ArrayList<>();
	
	
	@OneToMany(mappedBy="plan", fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private List<Cuota> cuotas = new ArrayList<>();

}
