package io.github.cwireset.tcc.service.imovel;

import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
public class BuscarImovelPorIdProprietarioService {
    @Autowired
    ImovelRepository repository;

    public Page<Imovel> buscar(Pageable pageable, Long idProprietario) {

        return repository.findAllByProprietarioId(pageable, idProprietario);
    }

}
