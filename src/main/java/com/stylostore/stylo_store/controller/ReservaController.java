package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Reserva;
import com.stylostore.stylo_store.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Obtener todas las reservas
    @GetMapping
    public List<Reserva> obtenerTodos() {
        return reservaService.obtenerTodos();
    }

    // Obtener reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.obtenerPorId(id);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nueva reserva
    @PostMapping
    public ResponseEntity<?> insertarReserva(@RequestBody Reserva reserva) {
        reservaService.insertarReserva(reserva);
        return ResponseEntity.ok("Reserva creada con éxito");
    }

    // Actualizar reserva
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        reservaService.actualizarReserva(id, reserva);
        return ResponseEntity.ok("Reserva actualizada con éxito");
    }

    // Eliminar reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }
}
