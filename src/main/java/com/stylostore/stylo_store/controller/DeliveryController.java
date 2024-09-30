package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Delivery;
import com.stylostore.stylo_store.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    // Obtener todos los deliveries
    @GetMapping
    public List<Delivery> obtenerTodos() {
        return deliveryService.obtenerTodos();
    }

    // Obtener delivery por ID
    @GetMapping("/{id}")
    public ResponseEntity<Delivery> obtenerPorId(@PathVariable Long id) {
        Delivery delivery = deliveryService.obtenerPorId(id);
        if (delivery != null) {
            return ResponseEntity.ok(delivery);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nuevo delivery
    @PostMapping
    public ResponseEntity<?> insertarDelivery(@RequestBody Delivery delivery) {
        deliveryService.insertarDelivery(delivery);
        return ResponseEntity.ok("Delivery creado con éxito");
    }

    // Actualizar delivery
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        deliveryService.actualizarDelivery(id, delivery);
        return ResponseEntity.ok("Delivery actualizado con éxito");
    }

    // Eliminar delivery
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDelivery(@PathVariable Long id) {
        deliveryService.eliminarDelivery(id);
        return ResponseEntity.noContent().build();
    }
}
