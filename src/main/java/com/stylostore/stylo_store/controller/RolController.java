package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Rol;
import com.stylostore.stylo_store.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    // Obtener todos los roles
    @GetMapping
    public List<Rol> obtenerTodos() {
        return rolService.obtenerTodos();
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerPorId(@PathVariable Long id) {
        Rol rol = rolService.obtenerPorId(id);
        if (rol != null) {
            return ResponseEntity.ok(rol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar un nuevo rol
    @PostMapping
    public ResponseEntity<Rol> insertarRol(@RequestBody Rol rol) {
        rolService.insertarRol(rol);
        return new ResponseEntity<>(rol, HttpStatus.CREATED);
    }

    // Actualizar un rol existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarRol(@PathVariable Long id, @RequestBody Rol rol) {
        Rol rolExistente = rolService.obtenerPorId(id);
        if (rolExistente != null) {
            rolService.actualizarRol(id, rol);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un rol por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}
