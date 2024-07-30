package org.example.models;

import java.io.Serializable;

public class Productos implements Serializable {

    static final long serialVersionUID = 42743972947724L;

    private String nombre;

    public Productos() {
    }

    public Productos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {

        return "Productos{" +
                "nombre='" + nombre + '\'' + '}';
    }
}
