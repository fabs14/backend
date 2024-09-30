package com.stylostore.stylo_store.controller;

import com.stylostore.stylo_store.model.CategoriaProducto;
import com.stylostore.stylo_store.service.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoriaproducto")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    // Obtener todas las relaciones Producto-Categoria
    @GetMapping
    public List<CategoriaProducto> obtenerTodos() {
        return categoriaProductoService.obtenerTodos();
    }

    // Obtener relaciones por Producto ID
    @GetMapping("/producto/{productoId}")
    public List<CategoriaProducto> obtenerPorProductoId(@PathVariable Long productoId) {
        return categoriaProductoService.obtenerPorProductoId(productoId);
    }

    // Obtener relaciones por Categoria ID
    @GetMapping("/categoria/{categoriaId}")
    public List<CategoriaProducto> obtenerPorCategoriaId(@PathVariable Long categoriaId) {
        return categoriaProductoService.obtenerPorCategoriaId(categoriaId);
    }

    // Insertar nueva relación entre Producto y Categoria
    @PostMapping
    public ResponseEntity<?> insertarCategoriaProducto(@RequestBody CategoriaProducto categoriaProducto) {
        categoriaProductoService.insertarCategoriaProducto(categoriaProducto);
        return ResponseEntity.ok("Producto asignado a la categoría con éxito");
    }

    // Eliminar una relación Producto-Categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoriaProducto(@PathVariable Long id) {
        categoriaProductoService.eliminarCategoriaProducto(id);
        return ResponseEntity.noContent().build();
    }
}
