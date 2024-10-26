package com.dlopez.taller3.service;

import com.dlopez.taller3.model.Usuario;
import com.dlopez.taller3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Crear un usuario.
    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Obtener todos los usuarios.
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    //Obtener usuario por Id.
    public Optional<Usuario> getUserById(Long id) {
        return usuarioRepository.findById(id);
    }

    //Actualizar un usuario.
    public Usuario updateUser(Long id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setRol(usuarioDetails.getRol());
        return usuarioRepository.save(usuario);
    }

    //Eliminar un usuario.
    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }
}