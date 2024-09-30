package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Pago;
import com.stylostore.stylo_store.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Obtener todos los pagos
    @GetMapping
    public List<Pago> obtenerTodos() {
        return pagoService.obtenerTodos();
    }

    // Obtener pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPorId(@PathVariable Long id) {
        Pago pago = pagoService.obtenerPorId(id);
        if (pago != null) {
            return ResponseEntity.ok(pago);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nuevo pago
    @PostMapping
    public ResponseEntity<?> insertarPago(@RequestBody Pago pago) {
        pagoService.insertarPago(pago);
        return ResponseEntity.ok("Pago registrado con éxito");
    }

    // Actualizar pago
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPago(@PathVariable Long id, @RequestBody Pago pago) {
        pagoService.actualizarPago(id, pago);
        return ResponseEntity.ok("Pago actualizado con éxito");
    }

    // Eliminar pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }
}
