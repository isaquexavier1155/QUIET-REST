package io.github.cwireset.tcc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioComEsseEmailJaCadastradoException extends Exception {
    public UsuarioComEsseEmailJaCadastradoException(String tipo, String parametro) {
        super(String.format("Já existe um recurso do tipo Usuario com %s com o valor '%s'.", tipo, parametro));
    }

}
