package io.github.cwireset.tcc.service.imovel;

import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.domain.Usuario;
import io.github.cwireset.tcc.repository.ImovelRepository;
import io.github.cwireset.tcc.request.CadastrarImovelRequest;
import io.github.cwireset.tcc.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastrarImovelService {
    @Autowired
    ImovelRepository repository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    public Imovel cadastrar(CadastrarImovelRequest cadastrarImovelRequest) {
        //Primeiro verifica se existe um usuario cadastrado referente ao idProprietario no body do Postman
        //Regra: cada Usuario tem seu id vinculado com um idProprietario
        Usuario proprietario = buscarUsuarioPorIdService.buscar(cadastrarImovelRequest.getIdProprietario());

//Depois constroi um objeto chamado imovel com os atributos da classe dominio Imovel
        Imovel imovel= Imovel.builder()
                .caracteristicas(cadastrarImovelRequest.getCaracteristicas())
                .proprietario(proprietario)
                .endereco(cadastrarImovelRequest.getEndereco())
                .tipoImovel(cadastrarImovelRequest.getTipoImovel())
                .identificacao(cadastrarImovelRequest.getIdentificacao())
                .build();
//depois pega esse objeto chamado imovel construido acima , e salva no repositorio de Imoveis
        return repository.save(imovel);


    }


}
