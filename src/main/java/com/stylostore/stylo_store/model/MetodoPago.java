package com.stylostore.stylo_store.model;

public class MetodoPago {

    private Long id;
    private String nombreMetodo;

    // Constructor vacío
    public MetodoPago() {}

    // Constructor con parámetros
    public MetodoPago(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }
}
