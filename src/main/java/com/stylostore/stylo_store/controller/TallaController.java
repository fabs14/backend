package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Talla;
import com.stylostore.stylo_store.service.TallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tallas")
public class TallaController {

    @Autowired
    private TallaService tallaService;

    // Obtener todas las tallas
    @GetMapping
    public List<Talla> obtenerTodos() {
        return tallaService.obtenerTodos();
    }

    // Obtener talla por ID
    @GetMapping("/{id}")
    public ResponseEntity<Talla> obtenerPorId(@PathVariable Long id) {
        Talla talla = tallaService.obtenerPorId(id);
        if (talla != null) {
            return ResponseEntity.ok(talla);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nueva talla
    @PostMapping
    public ResponseEntity<?> insertarTalla(@RequestBody Talla talla) {
        tallaService.insertarTalla(talla);
        return ResponseEntity.ok("Talla creada con éxito");
    }

    // Actualizar talla
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTalla(@PathVariable Long id, @RequestBody Talla talla) {
        tallaService.actualizarTalla(id, talla);
        return ResponseEntity.ok("Talla actualizada con éxito");
    }

    // Eliminar talla
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTalla(@PathVariable Long id) {
        tallaService.eliminarTalla(id);
        return ResponseEntity.noContent().build();
    }
}
