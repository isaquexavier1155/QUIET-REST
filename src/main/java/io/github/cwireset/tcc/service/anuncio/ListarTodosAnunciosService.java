package io.github.cwireset.tcc.service.anuncio;

import io.github.cwireset.tcc.domain.Anuncio;
import io.github.cwireset.tcc.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListarTodosAnunciosService {
    @Autowired
    private AnuncioRepository anuncioRepository;
    public List<Anuncio> listarTodosAnuncios() {
        return anuncioRepository.findAll();
    }
}
