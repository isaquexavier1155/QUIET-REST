package io.github.cwireset.tcc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor//cria construtor completo
@NoArgsConstructor
@Builder
public class Usuario {

    private static final String REGEX_CPF= "[0-9]{11}";
    //o atributo para trabalhar com regex deve ser constante,
    // por isso utilizacao de static final antes do atributo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//para ocultar senha usuario
    private String senha;

    @NotBlank
    @Pattern(regexp = REGEX_CPF, message = "O CPF deve ser informado no formato 99999999999.")
    private String cpf;



    @NotNull
    private LocalDate dataNascimento;

    @ManyToOne(cascade = CascadeType.ALL)//gravacao relacional do banco
    @JoinColumn(name = "id_endereco")//como gravar no banco
    @Valid
    private Endereco endereco;

}
