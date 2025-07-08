package org.example.ejb.services;

import jakarta.ejb.Local;
import org.example.ejb.entitys.Usuario;

import java.util.List;

@Local // This annotation is used to specify that the interface is a local business interface of an EJB
public interface UsuarioService {

    List<Usuario> listar();
}
