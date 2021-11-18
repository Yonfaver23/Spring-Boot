package com.example.demo.controllers;
import com.example.demo.services.UsuarioDao;
import com.example.demo.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController{

    @Autowired
    private UsuarioDao usuarioDao;

    @CrossOrigin(origins = "http://localhost:4200" )
    @RequestMapping(value = "api/usuarios" , method = RequestMethod.GET)
    public List<Usuario> getUsuario(){
        return usuarioDao.getUser();
    }

    @CrossOrigin(origins = "http://localhost:4200" )
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUser(@PathVariable int id){
        return usuarioDao.usuario(id);
    }

    @CrossOrigin(origins = "http://localhost:4200" )
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody Usuario user){
        usuarioDao.update(id,user);

    }
    @CrossOrigin(origins = "http://localhost:4200" )
    @RequestMapping(value = "api/usuarios" , method = RequestMethod.POST)
    public void postUsuario(@Validated @RequestBody Usuario user){
         usuarioDao.registerUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200" )
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        usuarioDao.delete(id);

    }



}
