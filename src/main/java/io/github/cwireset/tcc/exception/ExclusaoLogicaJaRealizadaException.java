package io.github.cwireset.tcc.exception;

public class ExclusaoLogicaJaRealizadaException extends Exception{

    public ExclusaoLogicaJaRealizadaException( String descricao,Class clazz,  Object id) {
        super(String.format("Já foi feita a exclusao Lógica %s de um atributo chamado Excluido da classe %s com id com valor '%s'.", descricao, clazz.getSimpleName(), id));
    }

    public ExclusaoLogicaJaRealizadaException(String message) {
        super(message);
    }
}
