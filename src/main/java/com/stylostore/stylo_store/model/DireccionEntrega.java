package com.stylostore.stylo_store.model;

public class DireccionEntrega {

    private Long id;
    private String direccion;
    private String aliasDireccion;

    // Constructor vacío
    public DireccionEntrega() {}

    // Constructor con parámetros
    public DireccionEntrega(String direccion, String aliasDireccion) {
        this.direccion = direccion;
        this.aliasDireccion = aliasDireccion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAliasDireccion() {
        return aliasDireccion;
    }

    public void setAliasDireccion(String aliasDireccion) {
        this.aliasDireccion = aliasDireccion;
    }
}
