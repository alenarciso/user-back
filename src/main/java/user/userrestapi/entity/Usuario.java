package user.userrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private LocalDateTime registerDate;
    private String name;
    private String surName;
    private String email;
    private String phone;

    @Column(name = "is_enabled" ,columnDefinition = "boolean default false")
    private Boolean isEnabled;
}
