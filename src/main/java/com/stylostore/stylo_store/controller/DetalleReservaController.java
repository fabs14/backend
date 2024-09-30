package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.DetalleReserva;
import com.stylostore.stylo_store.service.DetalleReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallereserva")
public class DetalleReservaController {

    @Autowired
    private DetalleReservaService detalleReservaService;

    // Obtener todos los detalles de reserva
    @GetMapping
    public List<DetalleReserva> obtenerTodos() {
        return detalleReservaService.obtenerTodos();
    }

    // Obtener detalle de reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalleReserva> obtenerPorId(@PathVariable Long id) {
        DetalleReserva detalleReserva = detalleReservaService.obtenerPorId(id);
        if (detalleReserva != null) {
            return ResponseEntity.ok(detalleReserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nuevo detalle de reserva
    @PostMapping
    public ResponseEntity<?> insertarDetalleReserva(@RequestBody DetalleReserva detalleReserva) {
        detalleReservaService.insertarDetalleReserva(detalleReserva);
        return ResponseEntity.ok("Detalle de reserva creado con éxito");
    }

    // Actualizar detalle de reserva
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDetalleReserva(@PathVariable Long id, @RequestBody DetalleReserva detalleReserva) {
        detalleReservaService.actualizarDetalleReserva(id, detalleReserva);
        return ResponseEntity.ok("Detalle de reserva actualizado con éxito");
    }

    // Eliminar detalle de reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleReserva(@PathVariable Long id) {
        detalleReservaService.eliminarDetalleReserva(id);
        return ResponseEntity.noContent().build();
    }
}
