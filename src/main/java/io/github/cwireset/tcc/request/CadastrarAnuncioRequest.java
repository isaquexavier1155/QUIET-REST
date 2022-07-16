package io.github.cwireset.tcc.request;

import io.github.cwireset.tcc.domain.FormaPagamento;
import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.domain.TipoAnuncio;
import io.github.cwireset.tcc.domain.Usuario;
import lombok.*;

import javax.persistence.GeneratedValue;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class CadastrarAnuncioRequest {

    private String descricao;

    private long idAnunciante;

    //id imovel esta retornando 0
    private long idImovel;

    private TipoAnuncio tipoAnuncio;

    private Imovel imovel;

    private BigDecimal valorDiaria;

   // private Usuario anunciante;

    private List<FormaPagamento> formasAceitas;


}
