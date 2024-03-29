package user.userrestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "Campo Usuário é obrigatório!")
    private String userName;
    @NotEmpty(message = "Campo Senha é obrigatório!")
    private String password;
    private LocalDateTime registerDate;
    @NotEmpty(message = "Campo Nome é obrigatório!")
    private String name;
    private String surName;
    @Email(message = "Email inválido")
    @NotEmpty(message = "O campo Email é obrigatório!")
    private String email;
    private String phone;
    private LocalDateTime birthDate;
    @CPF(message = "CPF inválido")
    private String cpf;
    private Boolean isEnabled;
}
