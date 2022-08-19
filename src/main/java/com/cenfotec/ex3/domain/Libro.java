package com.cenfotec.ex3.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "libro_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToMany(mappedBy = "libros")
    Set<Hijo> hijos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
