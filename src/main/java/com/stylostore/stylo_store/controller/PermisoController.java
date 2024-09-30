package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Permiso;
import com.stylostore.stylo_store.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    // Obtener todos los permisos
    @GetMapping
    public List<Permiso> obtenerTodos() {
        return permisoService.obtenerTodos();
    }

    // Obtener permiso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Permiso> obtenerPorId(@PathVariable Long id) {
        Permiso permiso = permisoService.obtenerPorId(id);
        if (permiso != null) {
            return ResponseEntity.ok(permiso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nuevo permiso
    @PostMapping
    public ResponseEntity<?> insertarPermiso(@RequestBody Permiso permiso) {
        permisoService.insertarPermiso(permiso);
        return ResponseEntity.ok("Permiso creado con éxito");
    }

    // Actualizar permiso
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPermiso(@PathVariable Long id, @RequestBody Permiso permiso) {
        permisoService.actualizarPermiso(id, permiso);
        return ResponseEntity.ok("Permiso actualizado con éxito");
    }

    // Eliminar permiso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPermiso(@PathVariable Long id) {
        permisoService.eliminarPermiso(id);
        return ResponseEntity.noContent().build();
    }
}
