package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Reserva;
import com.stylostore.stylo_store.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Obtener todas las reservas
    public List<Reserva> obtenerTodos() {
        return reservaRepository.obtenerTodos();
    }

    // Obtener reserva por ID
    public Reserva obtenerPorId(Long id) {
        return reservaRepository.obtenerPorId(id);
    }

    // Insertar nueva reserva
    public void insertarReserva(Reserva reserva) {
        reservaRepository.insertarReserva(reserva);
    }

    // Actualizar reserva
    public void actualizarReserva(Long id, Reserva reserva) {
        reservaRepository.actualizarReserva(id, reserva);
    }

    // Eliminar reserva
    public void eliminarReserva(Long id) {
        reservaRepository.eliminarReserva(id);
    }
}
