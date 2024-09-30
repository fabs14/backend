package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.DetalleReserva;
import com.stylostore.stylo_store.repository.DetalleReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleReservaService {

    @Autowired
    private DetalleReservaRepository detalleReservaRepository;

    // Obtener todos los detalles de reserva
    public List<DetalleReserva> obtenerTodos() {
        return detalleReservaRepository.obtenerTodos();
    }

    // Obtener detalle de reserva por ID
    public DetalleReserva obtenerPorId(Long id) {
        return detalleReservaRepository.obtenerPorId(id);
    }

    // Insertar nuevo detalle de reserva
    public void insertarDetalleReserva(DetalleReserva detalleReserva) {
        detalleReservaRepository.insertarDetalleReserva(detalleReserva);
    }

    // Actualizar detalle de reserva
    public void actualizarDetalleReserva(Long id, DetalleReserva detalleReserva) {
        detalleReservaRepository.actualizarDetalleReserva(id, detalleReserva);
    }

    // Eliminar detalle de reserva
    public void eliminarDetalleReserva(Long id) {
        detalleReservaRepository.eliminarDetalleReserva(id);
    }
}
