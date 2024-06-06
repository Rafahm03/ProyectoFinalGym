package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Socio implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String username, password, nombre, apellidos, gmail, direccion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_alta;

    private boolean admin;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_socio_plan"))
    private Plan plan;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Suscripcion",
        joinColumns = @JoinColumn(name = "socio_id"),
        inverseJoinColumns = @JoinColumn(name = "cuota_id")
    )
    @Builder.Default
    private List<Cuota> cuotas = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = "ROLE_";
        role += (admin) ? "ADMIN" : "USER";
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void addToPlan(Plan plan) {
        this.plan = plan;
        plan.getSocios().remove(this);
        this.plan = null;
    }

    public void removeFromPlan(Plan plan) {
        plan.getSocios().remove(this);
        this.plan = null;
    }

    public void addCuota(Cuota c) {
        this.cuotas.add(c);
        c.getSocios().add(this);
    }

    public void removeCuota(Cuota c) {
        c.getSocios().remove(this);
        this.cuotas.remove(c);
    }
}

