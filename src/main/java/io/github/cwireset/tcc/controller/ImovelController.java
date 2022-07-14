package io.github.cwireset.tcc.controller;


import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.request.CadastrarImovelRequest;
import io.github.cwireset.tcc.service.imovel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    private CadastrarImovelService cadastrarImovelService;

    @Autowired
    private ListarImovelService listarImovelService;

    @Autowired
    private BuscarImovelPorIdProprietarioService buscarImovelPorIdService;

    @Autowired
    private FindImovelByIdImovelService findImovelByIdImovelService;

    @Autowired
    private DeleteImovelByIdImovelService deleteImovelByIdImovelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Imovel cadastrarImoveis(@RequestBody @Valid CadastrarImovelRequest cadastrarImovelRequest){
     return  cadastrarImovelService.cadastrar(cadastrarImovelRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Imovel> listarImoveis(){
        return listarImovelService.listar();
    }

    @GetMapping("/proprietarios/{idProprietario}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Imovel> buscarById(@PageableDefault(sort = "identificacao") @ApiIgnore Pageable pageable, @PathVariable("idProprietario") Long idProprietario) {
        return buscarImovelPorIdService.buscar(pageable ,idProprietario);
    }

    @GetMapping("/{idImovel}")
    @ResponseStatus(HttpStatus.OK)
    public Imovel listImovelById(@PathVariable("idImovel") Long id){
        return  findImovelByIdImovelService.buscar(id);
    }

    @DeleteMapping("/{idImovel}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarImovelByIdImovel(@PathVariable("idImovel")Long id){
        deleteImovelByIdImovelService.deletar(id);
    }

//implemenatar Parte 3 Anunciar Imóvel

}
