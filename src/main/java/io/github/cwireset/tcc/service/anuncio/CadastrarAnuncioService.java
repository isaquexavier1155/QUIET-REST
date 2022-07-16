package io.github.cwireset.tcc.service.anuncio;

import io.github.cwireset.tcc.domain.Anuncio;
import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.domain.Usuario;
import io.github.cwireset.tcc.exception.RecursoJaExistenteException;
import io.github.cwireset.tcc.repository.AnuncioRepository;
import io.github.cwireset.tcc.repository.ImovelRepository;
import io.github.cwireset.tcc.request.CadastrarAnuncioRequest;
import io.github.cwireset.tcc.service.imovel.FindImovelByIdImovelService;
import io.github.cwireset.tcc.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarAnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private FindImovelByIdImovelService findImovelByIdImovelService;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    VerificadorExistenciaAnuncioNoMesmoImovel verificadorExistenciaAnuncioNoMesmoImovel;



    public Anuncio salvarAnuncioImovel(CadastrarAnuncioRequest cadastrarAnuncioRequest, Long id) {
        //primeiro verifica se existe anuncio para o imovel
        //regra nao pode permitir cadastrar dois anuncios no mesmo imovel (idImovel)
        if(anuncioRepository.existsByImovelIdAndExcluidoFalse(cadastrarAnuncioRequest.getIdImovel())){
        throw  new RecursoJaExistenteException(Anuncio.class, cadastrarAnuncioRequest.getIdImovel(), "IdImovel");
        }
        //se nao existir nenhum anuncio cadastrado para o Imovel passado no postman ele continua a execuçao

        //Busca os idAnunciante que é o Usuario e o idImovel
        Usuario verificaExistenciaAnunciante = buscarUsuarioPorIdService.buscar(cadastrarAnuncioRequest.getIdAnunciante());
        Imovel verificaExitenciaImovel = findImovelByIdImovelService.buscar(cadastrarAnuncioRequest.getIdImovel());

        //constroi os objetos com a requisicao recebida do body do Postman
        Anuncio anuncio = Anuncio.builder()
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
