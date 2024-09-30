package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Delivery;
import com.stylostore.stylo_store.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    // Obtener todos los deliveries
    public List<Delivery> obtenerTodos() {
        return deliveryRepository.obtenerTodos();
    }

    // Obtener delivery por ID
    public Delivery obtenerPorId(Long id) {
        return deliveryRepository.obtenerPorId(id);
    }

    // Insertar nuevo delivery
    public void insertarDelivery(Delivery delivery) {
        deliveryRepository.insertarDelivery(delivery);
    }

    // Actualizar delivery
    public void actualizarDelivery(Long id, Delivery delivery) {
        deliveryRepository.actualizarDelivery(id, delivery);
    }

    // Eliminar delivery
    public void eliminarDelivery(Long id) {
        deliveryRepository.eliminarDelivery(id);
    }
}
