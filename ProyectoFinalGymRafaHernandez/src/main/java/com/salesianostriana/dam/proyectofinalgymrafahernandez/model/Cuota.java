package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Cuota {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, descripcion;

    private double precio;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "cuota", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Socio> socios = new ArrayList<>();

    @OneToOne(mappedBy = "cuota", fetch = FetchType.EAGER)
    private Plan plan;
}
