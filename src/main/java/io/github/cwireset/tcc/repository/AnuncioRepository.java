package io.github.cwireset.tcc.repository;

import io.github.cwireset.tcc.domain.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    boolean existsByImovelIdAndExcluidoFalse(long idImovel);
}
