package io.github.cwireset.tcc.controller;

import io.github.cwireset.tcc.domain.Anuncio;
import io.github.cwireset.tcc.request.CadastrarAnuncioRequest;
import io.github.cwireset.tcc.service.anuncio.CadastrarAnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anuncios")
public class AnuncioController {

    @Autowired
    private CadastrarAnuncioService cadastrarAnuncioService;
    @PostMapping
    public Anuncio anunciarImovel(@RequestBody  CadastrarAnuncioRequest cadastrarAnuncioRequest){
        return cadastrarAnuncioService.salvarAnuncioImovel(cadastrarAnuncioRequest);

    }
}
