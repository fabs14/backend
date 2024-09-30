package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.Envio;
import com.stylostore.stylo_store.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    // Obtener todos los envíos
    @GetMapping
    public List<Envio> obtenerTodos() {
        return envioService.obtenerTodos();
    }

    // Obtener envío por ID
    @GetMapping("/{id}")
    public ResponseEntity<Envio> obtenerPorId(@PathVariable Long id) {
        Envio envio = envioService.obtenerPorId(id);
        if (envio != null) {
            return ResponseEntity.ok(envio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Insertar nuevo envío
    @PostMapping
    public ResponseEntity<?> insertarEnvio(@RequestBody Envio envio) {
        envioService.insertarEnvio(envio);
        return ResponseEntity.ok("Envío creado con éxito");
    }

    // Actualizar envío
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEnvio(@PathVariable Long id, @RequestBody Envio envio) {
        envioService.actualizarEnvio(id, envio);
        return ResponseEntity.ok("Envío actualizado con éxito");
    }

    // Eliminar envío
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEnvio(@PathVariable Long id) {
        envioService.eliminarEnvio(id);
        return ResponseEntity.noContent().build();
    }
}
