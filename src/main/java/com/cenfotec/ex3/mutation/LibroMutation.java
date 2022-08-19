package com.cenfotec.ex3.mutation;

import com.cenfotec.ex3.domain.Libro;
import com.cenfotec.ex3.services.LibroService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LibroMutation implements GraphQLMutationResolver {
    @Autowired
    private LibroService libroService;

    public Libro createLibro(String nombre) {
        return this.libroService.createLibro(nombre);
    }

    public Libro updateLibro(int id, String nombre){
        Optional<Libro> libro= libroService.getLibro(id);
        if(libro.isPresent()){
            Libro libroToUpdate = libro.get();
            libroToUpdate.setNombre(nombre);
            this.libroService.updateLibro(libroToUpdate);
            return libroToUpdate;
        } else {
            return null;
        }
    }
    public Libro deleteLibro(int id){
        Optional<Libro> libro= libroService.getLibro(id);
        if(libro.isPresent()){
            Libro libroToUpdate = libro.get();
            libroToUpdate.setStatus("Inactivo");
            this.libroService.updateLibro(libroToUpdate);
            return libroToUpdate;
        } else {
            return null;
        }
    }

}
