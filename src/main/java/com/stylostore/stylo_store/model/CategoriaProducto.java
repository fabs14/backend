package com.stylostore.stylo_store.model;

public class CategoriaProducto {

    private Long id;
    private Long productoId;
    private Long categoriaId;

    // Constructor vacío
    public CategoriaProducto() {}

    // Constructor con parámetros
    public CategoriaProducto(Long productoId, Long categoriaId) {
        this.productoId = productoId;
        this.categoriaId = categoriaId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
