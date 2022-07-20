package io.github.cwireset.tcc.controller;

import io.github.cwireset.tcc.domain.Anuncio;
import io.github.cwireset.tcc.request.CadastrarAnuncioRequest;
import io.github.cwireset.tcc.service.anuncio.CadastrarAnuncioService;
import io.github.cwireset.tcc.service.anuncio.DeletarAnuncioService;
import io.github.cwireset.tcc.service.anuncio.ListarAnunciosPorIdAnuncianteService;
import io.github.cwireset.tcc.service.anuncio.ListarTodosAnunciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

    @Autowired
    private ListarAnunciosPorIdAnuncianteService listarAnunciosPorIdAnuncianteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Anuncio anunciarImovel(@RequestBody  CadastrarAnuncioRequest cadastrarAnuncioRequest, Long id){
        return cadastrarAnuncioService.salvarAnuncioImovel(cadastrarAnuncioRequest, id);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Anuncio> listarTodosAnuncios(@PageableDefault (sort = "valorDiaria")@ApiIgnore Pageable pageable){
        return listarTodosAnunciosService.listarTodosAnuncios(pageable);
    }

    @GetMapping("/anunciantes/{idAnunciante}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Anuncio> listarAnunciaoPorIdAnunciante(@PathVariable("idAnunciante") Long idAnunciante, @PageableDefault(sort = "valorDiaria") @ApiIgnore Pageable pageable){
    return listarAnunciosPorIdAnuncianteService.listar(idAnunciante,pageable);
    }

    @DeleteMapping("/{id}")
    public void deletarAnuncio(@PathVariable("id") Long id){
       deletarAnuncioService.deletarAnuncioPorId(id);
    }
}
