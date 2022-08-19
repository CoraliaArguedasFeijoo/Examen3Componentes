package com.cenfotec.ex3.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hijo_id")
    private Long id;

    private String nombre;
    private String plan;
    private String alergias;
    private int madre;
    private int padre;

    @ManyToMany
    @JoinTable(name="libro_read", joinColumns = @JoinColumn(name = "hijo_id"), inverseJoinColumns = @JoinColumn(name = "libro_id"))
    Set<Libro> libros;


    public Hijo() {
    }

   public Hijo(Long id, String nombre, String plan, String alergias, int madre, int padre) {
        this.id = id;
        this.nombre = nombre;
        this.plan = plan;
        this.alergias = alergias;
        this.madre = madre;
        this.padre = padre;
    }

    public Hijo(Long id, String nombre, String plan, String alergias, int madre, int padre, Set<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.plan = plan;
        this.alergias = alergias;
        this.madre = madre;
        this.padre = padre;
        this.libros = libros;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getMadre() {
        return madre;
    }

    public void setMadre(int madre) {
        this.madre = madre;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
}
