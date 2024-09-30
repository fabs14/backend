package com.stylostore.stylo_store.model;

public class DetalleReserva {

    private Long id;
    private Long reservaId;
    private Long productoId;
    private Long tallaId;
    private int cantidad;

    // Constructor vacío
    public DetalleReserva() {}

    // Constructor con parámetros
    public DetalleReserva(Long reservaId, Long productoId, Long tallaId, int cantidad) {
        this.reservaId = reservaId;
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

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
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
}
