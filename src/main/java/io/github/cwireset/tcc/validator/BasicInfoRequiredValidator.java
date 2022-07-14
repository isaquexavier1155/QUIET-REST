package io.github.cwireset.tcc.validator;

import io.github.cwireset.tcc.domain.Endereco;
import io.github.cwireset.tcc.exception.TipoDominioException;

import java.time.LocalDate;
import java.util.zip.ZipInputStream;

public class BasicInfoRequiredValidator {

    public void accept( final String nome, final String email, final String senha, final String cpf, final LocalDate dataNascimento, final Endereco endereco, final TipoDominioException tipoDominioException) throws Exception {
       /* if (nome == null) {
            throw new NomeNaoInformadoException();
        }

        if (dataNascimento == null) {
            throw new DataNascimentoNaoInformadoException();
        }*/

        //if (anoInicioAtividade == null) {
       //     throw new UsuarioComEsseEmailJaCadastradoException();
       // }

       // if (nome.split(" ").length < 2) {
       //     throw new NomeSobrenomeObrigatorioException(tipoDominioException.getSingular());
       // }

       // if (LocalDate.now().isBefore(dataNascimento)) {
        //    throw new NascidosNoFuturoException(tipoDominioException.getPlural());
       // }

       // if (anoInicioAtividade <= dataNascimento.getYear()) {
       //     throw new AnoInicioAtividadeInvalidoException(tipoDominioException.getSingular());
      //  }
    }

   // public void accept(String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, TipoDominioException endereco) {
  //  }
}
