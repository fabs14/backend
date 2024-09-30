package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Factura;
import com.stylostore.stylo_store.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    // Obtener todas las facturas
    @GetMapping
    public List<Factura> obtenerTodos() {
        return facturaService.obtenerTodos();
    }

    // Obtener factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerPorId(@PathVariable Long id) {
        Factura factura = facturaService.obtenerPorId(id);
        if (factura != null) {
            return ResponseEntity.ok(factura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nueva factura
    @PostMapping
    public ResponseEntity<?> insertarFactura(@RequestBody Factura factura) {
        facturaService.insertarFactura(factura);
        return ResponseEntity.ok("Factura creada con éxito");
    }

    // Actualizar factura
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura) {
        facturaService.actualizarFactura(id, factura);
        return ResponseEntity.ok("Factura actualizada con éxito");
    }

    // Eliminar factura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }
}
