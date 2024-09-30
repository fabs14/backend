package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.MetodoPago;
import com.stylostore.stylo_store.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    // Obtener todos los métodos de pago
    public List<MetodoPago> obtenerTodos() {
        return metodoPagoRepository.obtenerTodos();
    }

    // Obtener método de pago por ID
    public MetodoPago obtenerPorId(Long id) {
        return metodoPagoRepository.obtenerPorId(id);
    }

    // Insertar nuevo método de pago
    public void insertarMetodoPago(MetodoPago metodoPago) {
        metodoPagoRepository.insertarMetodoPago(metodoPago);
    }

    // Actualizar método de pago
    public void actualizarMetodoPago(Long id, MetodoPago metodoPago) {
        metodoPagoRepository.actualizarMetodoPago(id, metodoPago);
    }

    // Eliminar método de pago
    public void eliminarMetodoPago(Long id) {
        metodoPagoRepository.eliminarMetodoPago(id);
    }
}
