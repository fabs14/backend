package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Categoria;
import com.stylostore.stylo_store.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> obtenerTodos() {
        return categoriaRepository.obtenerTodos();
    }

    // Obtener categoría por ID
    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.obtenerPorId(id);
    }

    // Insertar nueva categoría
    public void insertarCategoria(Categoria categoria) {
        categoriaRepository.insertarCategoria(categoria);
    }

    // Actualizar categoría
    public void actualizarCategoria(Long id, Categoria categoria) {
        categoriaRepository.actualizarCategoria(id, categoria);
    }

    // Eliminar categoría
    public void eliminarCategoria(Long id) {
        categoriaRepository.eliminarCategoria(id);
    }
}
