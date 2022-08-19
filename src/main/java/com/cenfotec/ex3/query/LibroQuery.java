package com.cenfotec.ex3.query;

import com.cenfotec.ex3.domain.Libro;
import com.cenfotec.ex3.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class LibroQuery implements GraphQLQueryResolver {
    @Autowired
    private LibroService libroService;

    public List<Libro> getLibros(int count) {
        return this.libroService.getAllLibros(count);
    }
    public Optional<Libro> getLibro(int id) {
        return this.libroService.getLibro(id);
    }
}
