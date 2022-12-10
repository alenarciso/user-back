package user.userrestapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioDTO implements Serializable {

    private Long id;
    private String userName;
    private String password;
    private LocalDateTime registerDate;
    private String name;
    private String surName;
    private String email;
    private String phone;
    private Boolean isEnabled;
}
