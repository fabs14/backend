package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Producto;
import com.stylostore.stylo_store.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.obtenerTodos();
    }

    // Obtener producto por ID
    public Producto obtenerPorId(Long id) {
        return productoRepository.obtenerPorId(id);
    }

    // Insertar nuevo producto
    public void insertarProducto(Producto producto) {
        productoRepository.insertarProducto(producto);
    }

    // Actualizar producto
    public void actualizarProducto(Long id, Producto producto) {
        productoRepository.actualizarProducto(id, producto);
    }

    // Eliminar producto
    public void eliminarProducto(Long id) {
        productoRepository.eliminarProducto(id);
    }
}
