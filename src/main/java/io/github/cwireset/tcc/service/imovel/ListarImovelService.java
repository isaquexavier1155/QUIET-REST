package io.github.cwireset.tcc.service.imovel;

import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarImovelService {

    @Autowired
    ImovelRepository imovelRepository;

    public Iterable<Imovel> listar() {
        return imovelRepository.findAll();
    }

    Page<Imovel> listarPorIdProprietario(Pageable pageable, Long id){
        return imovelRepository.findAllByProprietarioId(pageable, id);
    }
}
