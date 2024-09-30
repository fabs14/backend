package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Usuario;
import com.stylostore.stylo_store.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.obtenerTodos();
    }

    public Usuario obtenerPorEmail(String email) {
        return usuarioRepository.obtenerPorEmail(email);
    }

    public void insertarUsuario(Usuario usuario) {
        // Hashear la contraseña antes de guardarla
        String contraseñaHasheada = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(contraseñaHasheada);
        usuarioRepository.insertarUsuario(usuario);
    }

    public boolean verificarContraseña(String contraseñaIngresada, String contraseñaHash) {
        return passwordEncoder.matches(contraseñaIngresada, contraseñaHash);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.eliminarUsuario(id);
    }
}
