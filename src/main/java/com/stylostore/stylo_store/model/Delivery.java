package com.stylostore.stylo_store.model;

public class Delivery {

    private Long id;
    private String nombreEmpleado;

    // Constructor vacío
    public Delivery() {}

    // Constructor con parámetros
    public Delivery(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
}
