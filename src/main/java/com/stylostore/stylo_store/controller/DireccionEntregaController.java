package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.DireccionEntrega;
import com.stylostore.stylo_store.service.DireccionEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direccionentrega")
public class DireccionEntregaController {

    @Autowired
    private DireccionEntregaService direccionEntregaService;

    // Obtener todas las direcciones de entrega
    @GetMapping
    public List<DireccionEntrega> obtenerTodos() {
        return direccionEntregaService.obtenerTodos();
    }

    // Obtener dirección de entrega por ID
    @GetMapping("/{id}")
    public ResponseEntity<DireccionEntrega> obtenerPorId(@PathVariable Long id) {
        DireccionEntrega direccionEntrega = direccionEntregaService.obtenerPorId(id);
        if (direccionEntrega != null) {
            return ResponseEntity.ok(direccionEntrega);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nueva dirección de entrega
    @PostMapping
    public ResponseEntity<?> insertarDireccionEntrega(@RequestBody DireccionEntrega direccionEntrega) {
        direccionEntregaService.insertarDireccionEntrega(direccionEntrega);
        return ResponseEntity.ok("Dirección de entrega creada con éxito");
    }

    // Actualizar dirección de entrega
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDireccionEntrega(@PathVariable Long id, @RequestBody DireccionEntrega direccionEntrega) {
        direccionEntregaService.actualizarDireccionEntrega(id, direccionEntrega);
        return ResponseEntity.ok("Dirección de entrega actualizada con éxito");
    }

    // Eliminar dirección de entrega
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDireccionEntrega(@PathVariable Long id) {
        direccionEntregaService.eliminarDireccionEntrega(id);
        return ResponseEntity.noContent().build();
    }
}
