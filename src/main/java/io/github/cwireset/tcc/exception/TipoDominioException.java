package io.github.cwireset.tcc.exception;

public enum TipoDominioException {
    //ENDERECO("Endereco", "Enderecos"),
    USUARIO("Usuario", "Usuarios"),
    CPF("CPF", "CPFS"),
    EMAIL("E-Mail", "E-Mail`s"),
    DIRETOR("diretor", "diretores"),
    ESTUDIO("estúdio", "estúdios"),
    FILME("filme", "filmes");

    private final String singular;
    private final String plural;

    TipoDominioException(final String singular, final String plural) {
        this.singular = singular;
        this.plural = plural;
    }

    public String getSingular() {
        return singular;
    }

    public String getPlural() {
        return plural;
    }
}