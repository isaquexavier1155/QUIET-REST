package io.github.cwireset.tcc.service.anuncio;

import io.github.cwireset.tcc.domain.Anuncio;
import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.domain.Usuario;
import io.github.cwireset.tcc.repository.AnuncioRepository;
import io.github.cwireset.tcc.request.CadastrarAnuncioRequest;
import io.github.cwireset.tcc.request.CadastrarImovelRequest;
import io.github.cwireset.tcc.service.imovel.BuscarImovelPorIdProprietarioService;
import io.github.cwireset.tcc.service.imovel.FindImovelByIdImovelService;
import io.github.cwireset.tcc.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarAnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private FindImovelByIdImovelService findImovelByIdImovelService;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;


    public Anuncio salvarAnuncioImovel(CadastrarAnuncioRequest cadastrarAnuncioRequest) {

       Usuario verificaExistenciaAnunciante = buscarUsuarioPorIdService.buscar(cadastrarAnuncioRequest.getIdAnunciante());
        Imovel verificaExitenciaImovel = findImovelByIdImovelService.buscar(cadastrarAnuncioRequest.getIdImovel());


        Anuncio anuncio= Anuncio.builder()
                .imovel(cadastrarAnuncioRequest.getImovel())
                .imovel(verificaExitenciaImovel)
                .anunciante(verificaExistenciaAnunciante)
                .tipoAnuncio(cadastrarAnuncioRequest.getTipoAnuncio())
                .valorDiaria(cadastrarAnuncioRequest.getValorDiaria())
                .formasAceitas(cadastrarAnuncioRequest.getFormasAceitas())
                .descricao(cadastrarAnuncioRequest.getDescricao())
                .excluido(Boolean.FALSE)
                .build();


        return anuncioRepository.save(anuncio);
    }
}
