package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.CategoriaProducto;
import com.stylostore.stylo_store.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    // Insertar nueva relación entre Producto y Categoria
    public void insertarCategoriaProducto(CategoriaProducto categoriaProducto) {
        categoriaProductoRepository.insertarCategoriaProducto(categoriaProducto);
    }

    // Obtener todas las relaciones
    public List<CategoriaProducto> obtenerTodos() {
        return categoriaProductoRepository.obtenerTodos();
    }

    // Obtener relaciones por Producto ID
    public List<CategoriaProducto> obtenerPorProductoId(Long productoId) {
        return categoriaProductoRepository.obtenerPorProductoId(productoId);
    }

    // Obtener relaciones por Categoria ID
    public List<CategoriaProducto> obtenerPorCategoriaId(Long categoriaId) {
        return categoriaProductoRepository.obtenerPorCategoriaId(categoriaId);
    }

    // Eliminar relación
    public void eliminarCategoriaProducto(Long id) {
        categoriaProductoRepository.eliminarCategoriaProducto(id);
    }
}
