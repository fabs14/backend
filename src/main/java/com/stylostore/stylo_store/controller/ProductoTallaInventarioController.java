package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.ProductoTallaInventario;
import com.stylostore.stylo_store.service.ProductoTallaInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productotallainventario")
public class ProductoTallaInventarioController {

    @Autowired
    private ProductoTallaInventarioService inventarioService;

    // Obtener todos los registros de inventario
    @GetMapping
    public List<ProductoTallaInventario> obtenerTodos() {
        return inventarioService.obtenerTodos();
    }

    // Obtener inventario por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoTallaInventario> obtenerPorId(@PathVariable Long id) {
        ProductoTallaInventario inventario = inventarioService.obtenerPorId(id);
        if (inventario != null) {
            return ResponseEntity.ok(inventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nuevo inventario
    @PostMapping
    public ResponseEntity<?> insertarProductoTallaInventario(@RequestBody ProductoTallaInventario inventario) {
        inventarioService.insertarProductoTallaInventario(inventario);
        return ResponseEntity.ok("Inventario agregado con éxito");
    }

    // Actualizar inventario
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProductoTallaInventario(@PathVariable Long id, @RequestBody ProductoTallaInventario inventario) {
        inventarioService.actualizarProductoTallaInventario(id, inventario);
        return ResponseEntity.ok("Inventario actualizado con éxito");
    }

    // Eliminar inventario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProductoTallaInventario(@PathVariable Long id) {
        inventarioService.eliminarProductoTallaInventario(id);
        return ResponseEntity.noContent().build();
    }
}
