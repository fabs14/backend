package com.stylostore.stylo_store.model;

public class Permiso {

    private Long id;
    private String nombre;

    // Constructor vacío
    public Permiso() {}

    // Constructor con parámetros
    public Permiso(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
