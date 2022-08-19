package com.cenfotec.ex3.controller;

import com.cenfotec.ex3.domain.Hijo;
import com.cenfotec.ex3.domain.Libro;
import com.cenfotec.ex3.services.HijoService;
import com.cenfotec.ex3.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping({"/hijos"})
public class HijoController {
    @Autowired
    private HijoService hijoService;
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List getAll(){
        return hijoService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Hijo> findById(@PathVariable Long id){
        Optional<Hijo> result = hijoService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Hijo create(@RequestBody Hijo contact){
        return hijoService.save(contact).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Hijo> update(@PathVariable("id") Long id,
                                         @RequestBody Hijo contact){
        contact.setId(id);
        Optional<Hijo> result = hijoService.update(contact);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/libros/{id}")
    public ResponseEntity<Hijo> updateLibros(@PathVariable("id") Long id,
                                       @RequestBody int idLibro){

        Optional<Libro> libroRetornado =libroService.getLibro(idLibro);
        if(libroRetornado.isPresent()) {
            Libro libro=libroRetornado.get();
            Optional<Hijo> optionalHijo= hijoService.findById(id);
            Hijo hijo=optionalHijo.get();
            Set<Libro> libosHijo= hijo.getLibros();
            libosHijo.add(libro);
            hijo.setLibros(libosHijo);
            Optional<Hijo> result = hijoService.update(hijo);
            if (result.isPresent()) {
                return ResponseEntity.ok().body(result.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (hijoService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
