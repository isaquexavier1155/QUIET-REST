package io.github.cwireset.tcc.service.anuncio;

import io.github.cwireset.tcc.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarAnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

   public void deletarAnuncioPorId(Long id){
   //metodo verifica se existe anuncio para excluir

      // anuncioRepository.delete(Long id);
   }
}
