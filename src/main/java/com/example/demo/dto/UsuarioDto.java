package com.example.demo.dto;


import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {
    @NotNull(message = "El id es requerido")
    protected Integer id;
    private String name;
    private String lastname;
    private String email;
    private String telphone;
}
