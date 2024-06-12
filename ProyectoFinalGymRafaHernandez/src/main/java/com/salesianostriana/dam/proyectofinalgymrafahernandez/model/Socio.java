package com.salesianostriana.dam.proyectofinalgymrafahernandez.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_socio_cuota"))
    private Cuota cuota;
    
    @OneToMany(mappedBy = "socio")
    private List<Reserva> reservas;


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

    public void setPlan(Plan plan) {
        this.plan = plan;
        plan.getSocios().add(this);
    }

    public void removeFromPlan(Plan plan) {
        plan.getSocios().remove(this);
        this.plan = null;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
        cuota.getSocios().add(this);
    }

    public void removeCuota(Cuota cuota) {
        cuota.getSocios().remove(this);
        this.cuota = null;
    }
}
