package com.stylostore.stylo_store.model;

public class DetallePedido {

    private Long id;
    private Long pedidoId;
    private Long productoId;
    private Long tallaId;
    private int cantidad;

    // Constructor vacío
    public DetallePedido() {}

    // Constructor con parámetros
    public DetallePedido(Long pedidoId, Long productoId, Long tallaId, int cantidad) {
        this.pedidoId = pedidoId;
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

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
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
