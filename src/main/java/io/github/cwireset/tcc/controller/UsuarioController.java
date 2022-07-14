package io.github.cwireset.tcc.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.cwireset.tcc.domain.Usuario;
import io.github.cwireset.tcc.request.AtualizarUsuarioRequest;
import io.github.cwireset.tcc.service.usuario.AtualizarUsuarioService;
import io.github.cwireset.tcc.service.usuario.BuscarUsuarioPorCpfService;
import io.github.cwireset.tcc.service.usuario.BuscarUsuarioPorIdService;
import io.github.cwireset.tcc.service.usuario.CadastrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    BuscarUsuarioPorCpfService buscarUsuarioPorCpfService;

    @Autowired
    private AtualizarUsuarioService atualizarUsuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario) {
        return cadastrarUsuarioService.salvar(usuario);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> consultarUsuarios() throws Exception {//aqui deu certo nao alterar
       return buscarUsuarioPorIdService.consultarUsuarios();
    }

    @GetMapping("/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscar(@PathVariable("idUsuario") Long id) {
        return buscarUsuarioPorIdService.buscar(id);
    }


    @GetMapping("/cpf/{cpf}")
    public Usuario buscarUsuarioPorCpf(@PathVariable("cpf") String cpf) {
        Usuario usuario = buscarUsuarioPorCpfService.buscarPorCpf(cpf);
        return usuario;
    }

    @PutMapping("{idUsuario}")
    public Usuario alterarUsuario(@PathVariable("idUsuario") Long id, @RequestBody @Valid AtualizarUsuarioRequest atualizarUsuarioRequest) {
      return atualizarUsuarioService.atualizar(id, atualizarUsuarioRequest);
        //primeiro verifica se nao existe um email e um id na classe atualizarUsuarioRequest
        //se existir ocorre um erro
        //se nao existir
        //busca o usuario pelo id
        //seta informaçoes de cada campo usando a classe atualizarUsuarioRequest que
        // é um Dto, (somente armazena dados)
        //retorna ja salvando um novo usuario

    }
}
