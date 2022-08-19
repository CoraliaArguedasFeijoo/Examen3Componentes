package com.cenfotec.ex3.repositories;

import com.cenfotec.ex3.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
