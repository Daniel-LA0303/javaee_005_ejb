package services;

import jakarta.ejb.Local;
import org.example.ejb.entitys.Usuario;

import java.util.List;

@Local
public interface UsuarioService {

    List<Usuario> listar();
}
