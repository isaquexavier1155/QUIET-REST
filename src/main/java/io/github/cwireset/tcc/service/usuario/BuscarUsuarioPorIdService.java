package io.github.cwireset.tcc.service.usuario;

import io.github.cwireset.tcc.domain.Usuario;
import io.github.cwireset.tcc.exception.ListaVaziaException;
import io.github.cwireset.tcc.exception.RecursoNaoEncontradoException;
import io.github.cwireset.tcc.exception.TipoDominioException;
import io.github.cwireset.tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarUsuarioPorIdService {

    @Autowired
    private UsuarioRepository repository;

    //metodo abaixo é usado pela classe CadastrarImovelService
    public Usuario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Usuario.class, id, "Id"));
    }
    //metodo abaixo é usado pela classe UsuarioController
    public List<Usuario> consultarUsuarios() throws Exception {
        final List<Usuario> usuarios = repository.findAll();

        if (usuarios.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.USUARIO.getSingular(), TipoDominioException.USUARIO.getPlural());
        }

        return usuarios;
    }

}
