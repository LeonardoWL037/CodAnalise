package com.codanalise.dto;


import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
}
