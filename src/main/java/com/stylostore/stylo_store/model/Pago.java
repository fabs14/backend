package com.stylostore.stylo_store.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Pago {

    private Long id;
    private LocalDateTime fechaPago;
    private LocalTime horaPago;
    private double montoTotal;
    private Long metodoPagoId;

    // Constructor vacío
    public Pago() {}

    // Constructor con parámetros
    public Pago(LocalTime horaPago, double montoTotal, Long metodoPagoId) {
        this.horaPago = horaPago;
        this.montoTotal = montoTotal;
        this.metodoPagoId = metodoPagoId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalTime getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(LocalTime horaPago) {
        this.horaPago = horaPago;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Long getMetodoPagoId() {
        return metodoPagoId;
    }

    public void setMetodoPagoId(Long metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
    }
}
