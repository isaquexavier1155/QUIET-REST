package io.github.cwireset.tcc.service.imovel;

import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class DeleteImovelByIdImovelService {
    @Autowired
    private ImovelRepository repository;

    @Autowired
    private FindImovelByIdImovelService findImovelByIdImovelService;

    public void deletar(Long id) {
        Imovel imovel= findImovelByIdImovelService.buscar(id);
        repository.delete(imovel);
    }
}
