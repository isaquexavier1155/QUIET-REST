package io.github.cwireset.tcc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(Class clazz, Object CPF, String descricao) {
        super(String.format("Nenhum(a) %s com %s com o valor '%s' foi encontrado.", clazz.getSimpleName(), descricao, CPF));
    }

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }
}
