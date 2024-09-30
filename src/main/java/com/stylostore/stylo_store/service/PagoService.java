package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Pago;
import com.stylostore.stylo_store.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    // Obtener todos los pagos
    public List<Pago> obtenerTodos() {
        return pagoRepository.obtenerTodos();
    }

    // Obtener pago por ID
    public Pago obtenerPorId(Long id) {
        return pagoRepository.obtenerPorId(id);
    }

    // Insertar nuevo pago
    public void insertarPago(Pago pago) {
        pagoRepository.insertarPago(pago);
    }

    // Actualizar pago
    public void actualizarPago(Long id, Pago pago) {
        pagoRepository.actualizarPago(id, pago);
    }

    // Eliminar pago
    public void eliminarPago(Long id) {
        pagoRepository.eliminarPago(id);
    }
}
