package io.github.cwireset.tcc.service.anuncio;

import io.github.cwireset.tcc.domain.Anuncio;
import io.github.cwireset.tcc.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DeletarAnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;
    @Autowired
    private BuscarAnuncioPorIdService buscarAnuncioPorIdService;

   public void deletarAnuncioPorId(Long idAnuncio){
       Anuncio anuncio = buscarAnuncioPorIdService.buscar(idAnuncio);
       anuncio.setExcluido(true);
       //exclusao lógica= consiste em alterar atributo booleam excluido da domain Anuncio refletindo apenas no banco de dados mas não
       // apagando verdadeiramente
       anuncioRepository.save(anuncio);
   }
}
