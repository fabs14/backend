package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.MetodoPago;
import com.stylostore.stylo_store.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodospago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    // Obtener todos los métodos de pago
    @GetMapping
    public List<MetodoPago> obtenerTodos() {
        return metodoPagoService.obtenerTodos();
    }

    // Obtener método de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> obtenerPorId(@PathVariable Long id) {
        MetodoPago metodoPago = metodoPagoService.obtenerPorId(id);
        if (metodoPago != null) {
            return ResponseEntity.ok(metodoPago);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nuevo método de pago
    @PostMapping
    public ResponseEntity<?> insertarMetodoPago(@RequestBody MetodoPago metodoPago) {
        metodoPagoService.insertarMetodoPago(metodoPago);
        return ResponseEntity.ok("Método de pago creado con éxito");
    }

    // Actualizar método de pago
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMetodoPago(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        metodoPagoService.actualizarMetodoPago(id, metodoPago);
        return ResponseEntity.ok("Método de pago actualizado con éxito");
    }

    // Eliminar método de pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMetodoPago(@PathVariable Long id) {
        metodoPagoService.eliminarMetodoPago(id);
        return ResponseEntity.noContent().build();
    }
}
