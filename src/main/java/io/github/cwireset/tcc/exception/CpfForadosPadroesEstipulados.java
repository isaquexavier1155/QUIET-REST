package io.github.cwireset.tcc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfForadosPadroesEstipulados extends Exception {
    public CpfForadosPadroesEstipulados(String tipo, String parametro) {
            super(String.format("O CPF deve ser informado no formato 99999999999.", tipo, parametro));
        }

    }

