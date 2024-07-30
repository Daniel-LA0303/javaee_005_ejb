package org.example.service;

import jakarta.ejb.Stateless;
import org.example.models.Productos;

import java.util.ArrayList;
import java.util.List;

//@RequestScoped //esto es para que se cree una instancia por cada peticion
@Stateless
public class ServiceEBJ implements EJBServiceRemote {

    private int contador;


    public String hello(String str) {

        //degub
        System.out.println("Imprimiendo dentro del ejb con instancia" + this);

        contador++;
        System.out.println("Contador: " + contador);

        return "Hello world!" + str;
    }

    @Override
    public List<Productos> listarProductos() {
        List<Productos> productos = new ArrayList<>();

        productos.add(new Productos("Producto 1"));
        productos.add(new Productos("Producto 2"));
        productos.add(new Productos("Producto 3"));

        return productos;
    }

    @Override
    public Productos crear(Productos producto) {
        Productos producto1 = new Productos();
        producto1.setNombre(producto.getNombre());
        System.out.println("Producto creado: " + producto1);
        return producto1;
    }
}
