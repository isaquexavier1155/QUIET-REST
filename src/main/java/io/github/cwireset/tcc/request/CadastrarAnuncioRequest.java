package io.github.cwireset.tcc.request;

import io.github.cwireset.tcc.domain.FormaPagamento;
import io.github.cwireset.tcc.domain.Imovel;
import io.github.cwireset.tcc.domain.TipoAnuncio;
import io.github.cwireset.tcc.domain.Usuario;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class CadastrarAnuncioRequest {

    @NotBlank
    private String descricao;
    @NotBlank
    private long idAnunciante;
    @NotBlank
    private long idImovel;
    @NotBlank
    private TipoAnuncio tipoAnuncio;

    private Imovel imovel;
    @NotBlank
    private BigDecimal valorDiaria;
    @NotBlank
    private List<FormaPagamento> formasAceitas;

}
