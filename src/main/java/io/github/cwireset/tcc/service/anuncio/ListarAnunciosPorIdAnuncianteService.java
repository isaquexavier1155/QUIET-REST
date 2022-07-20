package io.github.cwireset.tcc.service.anuncio;

import io.github.cwireset.tcc.domain.Anuncio;
import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.exception.RecursoNaoEncontradoException;
import io.github.cwireset.tcc.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarAnunciosPorIdAnuncianteService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    public Page<Anuncio> listar(Long idAnunciante, Pageable pageable) {
        return anuncioRepository.findAllByAnuncianteIdAndExcluidoFalse(idAnunciante,pageable);
    }

}
