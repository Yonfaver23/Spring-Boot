package com.example.demo.services;

import com.example.demo.entity.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUser();

    void delete(int id);

    void registerUser(Usuario user);

    Usuario usuario(int id);

    void update( int id,Usuario user);
}
