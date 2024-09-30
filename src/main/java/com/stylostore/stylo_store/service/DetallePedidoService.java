package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.DetallePedido;
import com.stylostore.stylo_store.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    // Obtener todos los detalles de pedido
    public List<DetallePedido> obtenerTodos() {
        return detallePedidoRepository.obtenerTodos();
    }

    // Obtener detalle de pedido por ID
    public DetallePedido obtenerPorId(Long id) {
        return detallePedidoRepository.obtenerPorId(id);
    }

    // Insertar nuevo detalle de pedido
    public void insertarDetallePedido(DetallePedido detallePedido) {
        detallePedidoRepository.insertarDetallePedido(detallePedido);
    }

    // Actualizar detalle de pedido
    public void actualizarDetallePedido(Long id, DetallePedido detallePedido) {
        detallePedidoRepository.actualizarDetallePedido(id, detallePedido);
    }

    // Eliminar detalle de pedido
    public void eliminarDetallePedido(Long id) {
        detallePedidoRepository.eliminarDetallePedido(id);
    }
}
