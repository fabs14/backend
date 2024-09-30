package com.stylostore.stylo_store.model;

import java.time.LocalDateTime;

public class Factura {

    private Long id;
    private Long pedidoId;
    private String nombreCliente;
    private String nit;
    private LocalDateTime fechaEmision;
    private double total;

    // Constructor vacío
    public Factura() {}

    // Constructor con parámetros
    public Factura(Long pedidoId, String nombreCliente, String nit, double total) {
        this.pedidoId = pedidoId;
        this.nombreCliente = nombreCliente;
        this.nit = nit;
        this.total = total;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
