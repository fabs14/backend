package com.stylostore.stylo_store.model;

import java.time.LocalDateTime;

public class Reserva {

    private Long id;
    private Long usuarioId;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaExpiracion;

    // Constructor vacío
    public Reserva() {}

    // Constructor con parámetros
    public Reserva(Long usuarioId, LocalDateTime fechaExpiracion) {
        this.usuarioId = usuarioId;
        this.fechaExpiracion = fechaExpiracion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
