package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.DireccionEntrega;
import com.stylostore.stylo_store.repository.DireccionEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionEntregaService {

    @Autowired
    private DireccionEntregaRepository direccionEntregaRepository;

    // Obtener todas las direcciones de entrega
    public List<DireccionEntrega> obtenerTodos() {
        return direccionEntregaRepository.obtenerTodos();
    }

    // Obtener dirección de entrega por ID
    public DireccionEntrega obtenerPorId(Long id) {
        return direccionEntregaRepository.obtenerPorId(id);
    }

    // Insertar nueva dirección de entrega
    public void insertarDireccionEntrega(DireccionEntrega direccionEntrega) {
        direccionEntregaRepository.insertarDireccionEntrega(direccionEntrega);
    }

    // Actualizar dirección de entrega
    public void actualizarDireccionEntrega(Long id, DireccionEntrega direccionEntrega) {
        direccionEntregaRepository.actualizarDireccionEntrega(id, direccionEntrega);
    }

    // Eliminar dirección de entrega
    public void eliminarDireccionEntrega(Long id) {
        direccionEntregaRepository.eliminarDireccionEntrega(id);
    }
}
