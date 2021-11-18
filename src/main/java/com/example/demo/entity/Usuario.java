package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usarios")
public class Usuario {

     @Getter @Setter @Column(name = "id")
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @Getter @Setter @Column(name= "name")
    @NotBlank(message = "Tienes que agregar un nombre")
    @Size(min = 3, max = 100, message = "son minimomsomsos")
    private String name;

    @Getter @Setter @Column(name = "lastname")
    @NotBlank(message = "Tienes que agregrar un apellido")
    private String lastname;

    @Getter @Setter @Column(name = "email")
    @Size(min = 3, max = 100, message = "el correo electronico es muy corto")
    @NotBlank(message = "Tienes que agregar un correo")
    @Email(message = "Tienes que agregar un correo")
    private String email;

    @Getter @Setter @Column(name = "telephone")
    private  long telephone;




}
