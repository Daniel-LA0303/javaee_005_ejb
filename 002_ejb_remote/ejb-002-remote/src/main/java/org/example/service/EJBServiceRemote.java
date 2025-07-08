package org.example.service;


import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import org.example.models.Productos;

import java.util.List;

@Remote
public interface EJBServiceRemote {

    public String hello(String str);

    List<Productos> listarProductos();

    Productos crear(Productos producto);
}
