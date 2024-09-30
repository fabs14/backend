package com.stylostore.stylo_store.model;

public class DetalleRol {

    private Long id;
    private Long rolId;
    private Long permisoId;

    // Constructor vacío
    public DetalleRol() {}

    // Constructor con parámetros
    public DetalleRol(Long rolId, Long permisoId) {
        this.rolId = rolId;
        this.permisoId = permisoId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public Long getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Long permisoId) {
        this.permisoId = permisoId;
    }
}
