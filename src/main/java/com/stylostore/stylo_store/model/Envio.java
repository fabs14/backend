package com.stylostore.stylo_store.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Envio {

    private Long id;
    private Long pedidoId;
    private Long deliveryId;
    private Long sucursalId;
    private Long direccionEntregaId;
    private LocalDateTime fechaSalida;
    private LocalTime horaSalida;

    // Constructor vacío
    public Envio() {}

    // Constructor con parámetros
    public Envio(Long pedidoId, Long deliveryId, Long sucursalId, Long direccionEntregaId, LocalTime horaSalida) {
        this.pedidoId = pedidoId;
        this.deliveryId = deliveryId;
        this.sucursalId = sucursalId;
        this.direccionEntregaId = direccionEntregaId;
        this.horaSalida = horaSalida;
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

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Long getDireccionEntregaId() {
        return direccionEntregaId;
    }

    public void setDireccionEntregaId(Long direccionEntregaId) {
        this.direccionEntregaId = direccionEntregaId;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}
