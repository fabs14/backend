package com.stylostore.stylo_store.service;

import com.stylostore.stylo_store.model.Factura;
import com.stylostore.stylo_store.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    // Obtener todas las facturas
    public List<Factura> obtenerTodos() {
        return facturaRepository.obtenerTodos();
    }

    // Obtener factura por ID
    public Factura obtenerPorId(Long id) {
        return facturaRepository.obtenerPorId(id);
    }

    // Insertar nueva factura
    public void insertarFactura(Factura factura) {
        facturaRepository.insertarFactura(factura);
    }

    // Actualizar factura
    public void actualizarFactura(Long id, Factura factura) {
        facturaRepository.actualizarFactura(id, factura);
    }

    // Eliminar factura
    public void eliminarFactura(Long id) {
        facturaRepository.eliminarFactura(id);
    }
}
