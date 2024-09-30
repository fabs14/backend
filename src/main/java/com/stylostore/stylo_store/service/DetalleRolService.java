package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.DetalleRol;
import com.stylostore.stylo_store.repository.DetalleRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleRolService {

    @Autowired
    private DetalleRolRepository detalleRolRepository;

    // Insertar nuevo DetalleRol (asociar rol con permiso)
    public void insertarDetalleRol(DetalleRol detalleRol) {
        detalleRolRepository.insertarDetalleRol(detalleRol);
    }

    // Obtener todas las relaciones Rol-Permiso
    public List<DetalleRol> obtenerTodos() {
        return detalleRolRepository.obtenerTodos();
    }

    // Obtener relaciones por ID de Rol
    public List<DetalleRol> obtenerPorRolId(Long rolId) {
        return detalleRolRepository.obtenerPorRolId(rolId);
    }

    // Eliminar DetalleRol por ID
    public void eliminarDetalleRol(Long id) {
        detalleRolRepository.eliminarDetalleRol(id);
    }
}
