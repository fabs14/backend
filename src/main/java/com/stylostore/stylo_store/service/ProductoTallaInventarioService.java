package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.ProductoTallaInventario;
import com.stylostore.stylo_store.repository.ProductoTallaInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoTallaInventarioService {

    @Autowired
    private ProductoTallaInventarioRepository inventarioRepository;

    // Obtener todos los registros de inventario
    public List<ProductoTallaInventario> obtenerTodos() {
        return inventarioRepository.obtenerTodos();
    }

    // Obtener registro de inventario por ID
    public ProductoTallaInventario obtenerPorId(Long id) {
        return inventarioRepository.obtenerPorId(id);
    }

    // Insertar nuevo registro de inventario
    public void insertarProductoTallaInventario(ProductoTallaInventario inventario) {
        inventarioRepository.insertarProductoTallaInventario(inventario);
    }

    // Actualizar registro de inventario
    public void actualizarProductoTallaInventario(Long id, ProductoTallaInventario inventario) {
        inventarioRepository.actualizarProductoTallaInventario(id, inventario);
    }

    // Eliminar registro de inventario
    public void eliminarProductoTallaInventario(Long id) {
        inventarioRepository.eliminarProductoTallaInventario(id);
    }
}
