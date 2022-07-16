package io.github.cwireset.tcc.controller;

import io.github.cwireset.tcc.domain.Anuncio;
import io.github.cwireset.tcc.request.CadastrarAnuncioRequest;
import io.github.cwireset.tcc.service.anuncio.CadastrarAnuncioService;
import io.github.cwireset.tcc.service.anuncio.DeletarAnuncioService;
import io.github.cwireset.tcc.service.anuncio.ListarTodosAnunciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anuncios")
public class AnuncioController {

    @Autowired
    private CadastrarAnuncioService cadastrarAnuncioService;

    @Autowired
    private DeletarAnuncioService deletarAnuncioService;

    @Autowired
    private ListarTodosAnunciosService listarTodosAnunciosService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Anuncio anunciarImovel(@RequestBody  CadastrarAnuncioRequest cadastrarAnuncioRequest, Long id){
        return cadastrarAnuncioService.salvarAnuncioImovel(cadastrarAnuncioRequest, id);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Anuncio> listarTodosAnuncios(){
        return listarTodosAnunciosService.listarTodosAnuncios();
    }

    @DeleteMapping("id")
    public void deletarAnuncio(@PathVariable("id") Long id){
       deletarAnuncioService.deletarAnuncioPorId(id);
    }
}
