package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Rol;
import com.stylostore.stylo_store.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    // Insertar un nuevo rol
    public void insertarRol(Rol rol) {
        rolRepository.insertarRol(rol);
    }

    // Obtener todos los roles
    public List<Rol> obtenerTodos() {
        return rolRepository.obtenerTodos();
    }

    // Obtener un rol por ID
    public Rol obtenerPorId(Long id) {
        return rolRepository.obtenerPorId(id);
    }

    // Actualizar un rol
    public void actualizarRol(Long id, Rol rolActualizado) {
        Rol rol = rolRepository.obtenerPorId(id);
        if (rol != null) {
            rol.setNombre(rolActualizado.getNombre());
            rolRepository.actualizarRol(rol);
        }
    }

    // Eliminar un rol
    public void eliminarRol(Long id) {
        rolRepository.eliminarRol(id);
    }
}
