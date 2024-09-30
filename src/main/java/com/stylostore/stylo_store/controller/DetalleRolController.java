package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.DetalleRol;
import com.stylostore.stylo_store.service.DetalleRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallerol")
public class DetalleRolController {

    @Autowired
    private DetalleRolService detalleRolService;

    // Obtener todas las relaciones Rol-Permiso
    @GetMapping
    public List<DetalleRol> obtenerTodos() {
        return detalleRolService.obtenerTodos();
    }

    // Obtener relaciones por ID de Rol
    @GetMapping("/rol/{rolId}")
    public List<DetalleRol> obtenerPorRolId(@PathVariable Long rolId) {
        return detalleRolService.obtenerPorRolId(rolId);
    }

    // Insertar nueva relación entre Rol y Permiso
    @PostMapping
    public ResponseEntity<?> insertarDetalleRol(@RequestBody DetalleRol detalleRol) {
        detalleRolService.insertarDetalleRol(detalleRol);
        return ResponseEntity.ok("Permiso asignado al rol con éxito");
    }

    // Eliminar una relación Rol-Permiso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleRol(@PathVariable Long id) {
        detalleRolService.eliminarDetalleRol(id);
        return ResponseEntity.noContent().build();
    }
}
