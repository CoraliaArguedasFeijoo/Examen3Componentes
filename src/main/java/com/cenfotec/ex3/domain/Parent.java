package com.cenfotec.ex3.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent {
    @Id
    private int cedula;

    private String nombre;
    private String apellido;
    private String direccion;
    private int telefonoPrimario;
    private int telefonoSecundario;

    public Parent() {
    }

    public Parent(int cedula, String nombre, String apellido, String direccion, int telefonoPrimario, int telefonoSecundario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefonoPrimario = telefonoPrimario;
        this.telefonoSecundario = telefonoSecundario;
    }


    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefonoPrimario() {
        return telefonoPrimario;
    }

    public void setTelefonoPrimario(int telefonoPrimario) {
        this.telefonoPrimario = telefonoPrimario;
    }

    public int getTelefonoSecundario() {
        return telefonoSecundario;
    }

    public void setTelefonoSecundario(int telefonoSecundario) {
        this.telefonoSecundario = telefonoSecundario;
    }

}