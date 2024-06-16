package com.salesianostriana.dam.proyectofinalgymrafahernandez.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Cuota;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.model.Plan;
import com.salesianostriana.dam.proyectofinalgymrafahernandez.repos.CuotaRepositorio;

@Service
public class CuotaService extends BaseServiceImpl<Cuota, Long, CuotaRepositorio>{


    @Autowired
    private CuotaRepositorio cuotaRepositorio;

    public List<Cuota> findAll() {
        return cuotaRepositorio.findAll();
    }

    public Optional<Cuota> findById(Long id) {
        return  cuotaRepositorio.findById(id);
    }
    
    public List<Cuota> findByNombre(String nombre) {
		return cuotaRepositorio.findByNombreContainingIgnoreCase(nombre);
	}
}
