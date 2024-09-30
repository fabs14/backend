package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.DetallePedido;
import com.stylostore.stylo_store.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallepedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    // Obtener todos los detalles de pedido
    @GetMapping
    public List<DetallePedido> obtenerTodos() {
        return detallePedidoService.obtenerTodos();
    }

    // Obtener detalle de pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> obtenerPorId(@PathVariable Long id) {
        DetallePedido detallePedido = detallePedidoService.obtenerPorId(id);
        if (detallePedido != null) {
            return ResponseEntity.ok(detallePedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nuevo detalle de pedido
    @PostMapping
    public ResponseEntity<?> insertarDetallePedido(@RequestBody DetallePedido detallePedido) {
        detallePedidoService.insertarDetallePedido(detallePedido);
        return ResponseEntity.ok("Detalle de pedido creado con éxito");
    }

    // Actualizar detalle de pedido
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarDetallePedido(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        detallePedidoService.actualizarDetallePedido(id, detallePedido);
        return ResponseEntity.ok("Detalle de pedido actualizado con éxito");
    }

    // Eliminar detalle de pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetallePedido(@PathVariable Long id) {
        detallePedidoService.eliminarDetallePedido(id);
        return ResponseEntity.noContent().build();
    }
}
