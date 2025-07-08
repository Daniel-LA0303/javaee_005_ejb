package org.example.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.ejb.entitys.Usuario;
import org.example.ejb.repositories.UsuarioRepository;

import java.util.List;

@Stateless // This annotation is used to specify that the bean is a stateless session bean and can be used by multiple clients
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    private UsuarioRepository repository;

    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }
}
