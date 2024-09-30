package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Sucursal;
import com.stylostore.stylo_store.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    // Obtener todas las sucursales
    @GetMapping
    public List<Sucursal> obtenerTodos() {
        return sucursalService.obtenerTodos();
    }

    // Obtener sucursal por ID
    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> obtenerPorId(@PathVariable Long id) {
        Sucursal sucursal = sucursalService.obtenerPorId(id);
        if (sucursal != null) {
            return ResponseEntity.ok(sucursal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nueva sucursal
    @PostMapping
    public ResponseEntity<?> insertarSucursal(@RequestBody Sucursal sucursal) {
        sucursalService.insertarSucursal(sucursal);
        return ResponseEntity.ok("Sucursal creada con éxito");
    }

    // Actualizar sucursal
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        sucursalService.actualizarSucursal(id, sucursal);
        return ResponseEntity.ok("Sucursal actualizada con éxito");
    }

    // Eliminar sucursal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
        return ResponseEntity.noContent().build();
    }
}
