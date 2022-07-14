package io.github.cwireset.tcc.service.usuario;

import io.github.cwireset.tcc.domain.Usuario;
import io.github.cwireset.tcc.exception.RecursoJaExistenteException;
import io.github.cwireset.tcc.repository.UsuarioRepository;
import io.github.cwireset.tcc.request.AtualizarUsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    private ExisteUsuarioMesmoEmailService existeUsuarioMesmoEmailService;

    public Usuario atualizar(Long id, AtualizarUsuarioRequest atualizarUsuarioRequest) {
        if (existeUsuarioMesmoEmailService.existeComIdDiferente(atualizarUsuarioRequest.getEmail(), id)) {
            throw new RecursoJaExistenteException(Usuario.class, atualizarUsuarioRequest.getEmail(), "E-Mail");
        }
        //nao posso atualizar o usuario usando email e id de um usuario ja cadastrado
        //nao posso atualizar usuario nao existente
        //primeiro verifica se existe um email e um id  de um usuario cadastrado no banco de dados
        // usando a classe atualizarUsuarioRequest que é um dto
        //se existir ocorre um erro
        //se nao existir
        //cria um novo usuario
        //seta informaçoes de cada campo usando a classe atualizarUsuarioRequest que
        // é um Dto, (somente armazena dados)

        Usuario usuarioAtual = buscarUsuarioPorIdService.buscar(id);

        usuarioAtual.setEmail(atualizarUsuarioRequest.getEmail());
        usuarioAtual.setNome(atualizarUsuarioRequest.getNome());
        usuarioAtual.setSenha(atualizarUsuarioRequest.getSenha());
        usuarioAtual.setDataNascimento(atualizarUsuarioRequest.getDataNascimento());

        //verifica se o endereço nao é null
        //se nao for nullo
        //seta informaçoes de cada campo da classe Endereco ,usando a classe atualizarUsuarioRequest que
        // é um Dto, (somente armazena dados)
        if (atualizarUsuarioRequest.getEndereco() != null) {
            usuarioAtual.getEndereco().setBairro(atualizarUsuarioRequest.getEndereco().getBairro());
            usuarioAtual.getEndereco().setCep(atualizarUsuarioRequest.getEndereco().getCep());
            usuarioAtual.getEndereco().setComplemento(atualizarUsuarioRequest.getEndereco().getComplemento());
            usuarioAtual.getEndereco().setCidade(atualizarUsuarioRequest.getEndereco().getCidade());
            usuarioAtual.getEndereco().setEstado(atualizarUsuarioRequest.getEndereco().getEstado());
            usuarioAtual.getEndereco().setLogradouro(atualizarUsuarioRequest.getEndereco().getLogradouro());
            usuarioAtual.getEndereco().setNumero(atualizarUsuarioRequest.getEndereco().getNumero());
        } else {
            //se for null ele seta os dados de enderço como nullos
            //retorna ja salvando o usuario atualizado
            usuarioAtual.setEndereco(null);
        }

        return repository.save(usuarioAtual);
    }
}
