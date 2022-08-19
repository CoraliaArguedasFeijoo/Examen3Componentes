package com.cenfotec.ex3.services;

import com.cenfotec.ex3.domain.Libro;
import com.cenfotec.ex3.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    LibroRepository repo;

    public List<Libro> getAllLibros(int count) {
        return this.repo.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Libro> getLibro(int id) {
        return this.repo.findById(id);
    }

    public Libro createLibro(String nombre) {
        Libro vehicle = new Libro();
        vehicle.setNombre(nombre);
        vehicle.setStatus("Activo");
        return this.repo.save(vehicle);
    }

    public void updateLibro(Libro vehicleToUpdate) {
        this.repo.save(vehicleToUpdate);
    }


}

