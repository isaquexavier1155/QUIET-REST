package io.github.cwireset.tcc.service.anuncio;

import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.repository.ImovelRepository;
import io.github.cwireset.tcc.service.imovel.FindImovelByIdImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificadorExistenciaAnuncioNoMesmoImovel {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private FindImovelByIdImovelService findImovelByIdImovelService;


        public  boolean verificaSeExiteAnuncioParaEsseImovel(Long id){
                boolean verifica= imovelRepository.existsById(id);
                return verifica;
            }


}
