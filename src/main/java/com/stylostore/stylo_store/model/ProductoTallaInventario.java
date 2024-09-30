package com.stylostore.stylo_store.model;

import java.time.LocalDateTime;

public class ProductoTallaInventario {

    private Long id;
    private Long productoId;
    private Long tallaId;
    private int cantidad;
    private LocalDateTime fechaActualizacion;

    // Constructor vacío
    public ProductoTallaInventario() {}

    // Constructor con parámetros
    public ProductoTallaInventario(Long productoId, Long tallaId, int cantidad) {
        this.productoId = productoId;
        this.tallaId = tallaId;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getTallaId() {
        return tallaId;
    }

    public void setTallaId(Long tallaId) {
        this.tallaId = tallaId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
