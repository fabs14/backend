package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Usuario;
import com.stylostore.stylo_store.security.JwtUtil;
import com.stylostore.stylo_store.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        // Buscar el usuario en la base de datos (por su email)
        Usuario usuarioDb = usuarioService.obtenerPorEmail(usuario.getEmail());

        // Verificar la contraseña
        if (usuarioDb != null && usuarioService.verificarContraseña(usuario.getContraseña(), usuarioDb.getContraseña())) {
            // Generar el JWT
            String token = jwtUtil.generarToken(usuario.getEmail());
            return ResponseEntity.ok(token);
        }

        // Retornar error si las credenciales no son válidas
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }
}
