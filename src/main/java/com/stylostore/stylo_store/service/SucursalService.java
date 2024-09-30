package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Sucursal;
import com.stylostore.stylo_store.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    // Obtener todas las sucursales
    public List<Sucursal> obtenerTodos() {
        return sucursalRepository.obtenerTodos();
    }

    // Obtener sucursal por ID
    public Sucursal obtenerPorId(Long id) {
        return sucursalRepository.obtenerPorId(id);
    }

    // Insertar nueva sucursal
    public void insertarSucursal(Sucursal sucursal) {
        sucursalRepository.insertarSucursal(sucursal);
    }

    // Actualizar sucursal
    public void actualizarSucursal(Long id, Sucursal sucursal) {
        sucursalRepository.actualizarSucursal(id, sucursal);
    }

    // Eliminar sucursal
    public void eliminarSucursal(Long id) {
        sucursalRepository.eliminarSucursal(id);
    }
}
