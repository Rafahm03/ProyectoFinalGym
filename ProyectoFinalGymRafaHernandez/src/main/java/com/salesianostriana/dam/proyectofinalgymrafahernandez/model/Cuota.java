package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    private Plan plan;

    @ManyToMany(mappedBy = "cuotas", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Socio> socios = new ArrayList<>();

    public void addToPlan(Plan p) {
        p.getCuotas().add(this);
        this.plan = p;
    }

    public void removeFromPlan(Plan p) {
        p.getCuotas().remove(this);
        this.plan = null;
    }
}
