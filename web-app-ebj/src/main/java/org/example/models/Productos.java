package org.example.models;

public class Productos {

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
