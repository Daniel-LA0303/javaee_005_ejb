package services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.ejb.entitys.Usuario;
import repositories.UsuarioRepository;

import java.util.List;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    private UsuarioRepository repository;



    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }
}
