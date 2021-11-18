package com.example.demo.services;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.services.exeptions.ObjNotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImple implements UsuarioDao {
 private UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioDaoImple(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    @PersistenceContext
     EntityManager entityManager;


    @Override
    @Transactional
    public List<Usuario> getUser() {
       return this.usuarioRepository.findAll();
    }

    @Override
    public void delete(int id) {
         this.usuario(id);
         this.usuarioRepository.deleteById(id);
    }
    public Usuario usuario(int id) {
        return this.usuarioRepository.findById(id)
                .orElseThrow(() -> new ObjNotException("Este usuario no existe " + id));
    }

    @Override
    public void update(int id,Usuario user) {
        usuario(id);
        this.usuarioRepository.save((user));

    }

    @Override
    public void registerUser(Usuario user) {

        this.usuarioRepository.save(user);


    }
}
