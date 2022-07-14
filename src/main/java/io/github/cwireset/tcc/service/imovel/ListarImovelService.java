package io.github.cwireset.tcc.service.imovel;

import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarImovelService {

    @Autowired
    ImovelRepository repository;

    public Iterable<Imovel> listar() {
        return repository.findAll();
    }
}
