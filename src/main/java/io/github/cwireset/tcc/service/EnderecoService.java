package io.github.cwireset.tcc.service;

import io.github.cwireset.tcc.domain.Endereco;
import io.github.cwireset.tcc.domain.Usuario;
import io.github.cwireset.tcc.exception.TipoDominioException;
import io.github.cwireset.tcc.exception.UsuarioComEsseEmailJaCadastradoException;
import io.github.cwireset.tcc.repository.EnderecoRepository;
import io.github.cwireset.tcc.repository.UsuarioRepository;
import io.github.cwireset.tcc.validator.BasicInfoRequiredValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

   /* public void criarEndereco(EnderecoRequest enderecoRequest) throws UsuarioComEsseEmailJaCadastradoException {
        {
            new BasicInfoRequiredValidator().accept(enderecoRequest.getCep(), enderecoRequest.getLogradouro(), enderecoRequest.getNumero(), enderecoRequest.getComplemento(), enderecoRequest.getBairro(), enderecoRequest.getCidade(), enderecoRequest.getEstado(), TipoDominioException.ENDERECO);

            // if (enderecoRequest.getEmail() == enderecoRequest.getEmail()) {
            //     throw new UsuarioComEsseEmailJaCadastradoException();
            // }
            //se ja existir usuario com mesmo email retonar erro com mensagem

            final List<Endereco> enderecosCadastrados = repository.findAll();//esse

           /* for (Endereco enderecoCadastrado : enderecosCadastrados) {
                if (enderecoCadastrado.getNumero().equalsIgnoreCase(enderecoRequest.getNumero())) {
                    throw new UsuarioComEsseEmailJaCadastradoException(TipoDominioException.EMAIL.getSingular(), enderecoRequest.getCep());
                }
            }
            for (Endereco usuarioCadastrado : enderecosCadastrados) {
                if (enderecoRequest.getCpf().equalsIgnoreCase(enderecoRequest.getCpf())) {
                    throw new UsuarioComEsseEmailJaCadastradoException(TipoDominioException.CPF.getSingular(), enderecoRequest.getCpf());
                }
            }

            */
       /* for (Usuario usuarioCadastrado : enderecosCadastrados) {
           if (enderecoRequest.getEndereco().getCep().equalsIgnoreCase(format(enderecoRequest.getEndereco().getCep(), "###-####"))) {

              // enderecoRequest.getEndereco().setCep(getCep().substring(Integer.parseInt((5)+"-"+(3))));
               //format(enderecoRequest.getEndereco().getCep(), "###-####");
               enderecoRequest.getEndereco().getCep().matches("^\\([0-9]{5}\\-[0-9]{3}\\)$");
           }else{
               enderecoRequest.getEndereco().getCep().matches("^\\([0-9]{5}\\-[0-9]{3}\\)$");
           }
        }

        */

/*
            final Integer idGerado = enderecosCadastrados.size() + 1;

            final Endereco endereco = new Endereco(idGerado,enderecoRequest.getCep(), enderecoRequest.getLogradouro(), enderecoRequest.getNumero(), enderecoRequest.getComplemento(), enderecoRequest.getBairro(), enderecoRequest.getCidade(), enderecoRequest.getEstado());

            repository.save(endereco);


        }

        // public void formatarCep(EnderecoRequest enderecoRequest){
        //   if (enderecoRequest.getCep().equalsIgnoreCase(String.format(enderecoRequest.getCep(), "###-####"))){
        //}

//}
    }

 */
}
