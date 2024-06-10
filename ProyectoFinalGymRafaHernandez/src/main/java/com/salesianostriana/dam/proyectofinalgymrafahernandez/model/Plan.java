package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Plan {

    @Id
    @GeneratedValue
    private Long id;
    
    private String nombre, descripcion;
    
    private double precio;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "plan", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Socio> socios = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "cuota_id")
    private Cuota cuota;
  
    public void addToCuota(Cuota c) {
        c.setPlan(this);
        this.cuota = c;
    }

    public void removeFromCuota(Cuota c) {
        c.setPlan(null);
        this.cuota = null;
    }
}
