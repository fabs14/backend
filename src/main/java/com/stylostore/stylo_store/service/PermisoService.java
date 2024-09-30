package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Permiso;
import com.stylostore.stylo_store.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    // Obtener todos los permisos
    public List<Permiso> obtenerTodos() {
        return permisoRepository.obtenerTodos();
    }

    // Obtener permiso por ID
    public Permiso obtenerPorId(Long id) {
        return permisoRepository.obtenerPorId(id);
    }

    // Insertar nuevo permiso
    public void insertarPermiso(Permiso permiso) {
        permisoRepository.insertarPermiso(permiso);
    }

    // Actualizar permiso
    public void actualizarPermiso(Long id, Permiso permiso) {
        permisoRepository.actualizarPermiso(id, permiso);
    }

    // Eliminar permiso
    public void eliminarPermiso(Long id) {
        permisoRepository.eliminarPermiso(id);
    }
}
