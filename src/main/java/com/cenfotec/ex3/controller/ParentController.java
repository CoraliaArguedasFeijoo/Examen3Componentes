package com.cenfotec.ex3.controller;

import com.cenfotec.ex3.domain.Hijo;
import com.cenfotec.ex3.domain.Parent;
import com.cenfotec.ex3.services.HijoService;
import com.cenfotec.ex3.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/parents"})
public class ParentController {
    @Autowired
    private ParentService parentService;
    @Autowired
    private HijoService hijoService;

    @GetMapping
    public List getAll(){
        return parentService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Parent> findById(@PathVariable int id){
        Optional<Parent> result = parentService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Parent create(@RequestBody Parent contact){
        return parentService.save(contact).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Parent> update(@PathVariable("id") int id,
                                          @RequestBody Parent contact){
        contact.setCedula(id);
        Optional<Parent> result = parentService.update(contact);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (parentService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = {"/busqueda/{keyword}"})
    public List<Parent> search (@PathVariable("keyword") String keyword) {
        if (keyword != null) {
            List<Parent> list = parentService.getByKeyword(keyword);
            return list;
        }
        return null;
    }

    @RequestMapping(value = {"/informacion/{cedula}"})
    public List<Object> findParent (@PathVariable("cedula") int cedula) {
        Optional<Parent> result = parentService.findById(cedula);
        List<Object> list = new ArrayList<>();
        if (result.isPresent()){
            Parent p=result.get();
            list.add(p);
            List<Hijo> hijos = hijoService.findParentHijo(cedula);
            list.add(hijos);
            return list;
        } else {
           return null;
        }
    }

}
