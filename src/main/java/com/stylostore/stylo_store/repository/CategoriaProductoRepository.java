package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.CategoriaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoriaProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO categoriaproducto (producto_id, categoria_id) VALUES (?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM categoriaproducto";
    private final String SELECT_BY_PRODUCTO_ID_SQL = "SELECT * FROM categoriaproducto WHERE producto_id = ?";
    private final String SELECT_BY_CATEGORIA_ID_SQL = "SELECT * FROM categoriaproducto WHERE categoria_id = ?";
    private final String DELETE_SQL = "DELETE FROM categoriaproducto WHERE id = ?";

    // Insertar relación Categoria-Producto
    public int insertarCategoriaProducto(CategoriaProducto categoriaProducto) {
        return jdbcTemplate.update(INSERT_SQL, categoriaProducto.getProductoId(), categoriaProducto.getCategoriaId());
    }

    // Obtener todas las relaciones
    public List<CategoriaProducto> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new CategoriaProductoRowMapper());
    }

    // Obtener relaciones por Producto ID
    public List<CategoriaProducto> obtenerPorProductoId(Long productoId) {
        return jdbcTemplate.query(SELECT_BY_PRODUCTO_ID_SQL, new CategoriaProductoRowMapper(), productoId);
    }

    // Obtener relaciones por Categoria ID
    public List<CategoriaProducto> obtenerPorCategoriaId(Long categoriaId) {
        return jdbcTemplate.query(SELECT_BY_CATEGORIA_ID_SQL, new CategoriaProductoRowMapper(), categoriaId);
    }

    // Eliminar relación
    public int eliminarCategoriaProducto(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto CategoriaProducto
    private static class CategoriaProductoRowMapper implements RowMapper<CategoriaProducto> {
        @SuppressWarnings("null")
        @Override
        public CategoriaProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoriaProducto categoriaProducto = new CategoriaProducto();
            categoriaProducto.setId(rs.getLong("id"));
            categoriaProducto.setProductoId(rs.getLong("producto_id"));
            categoriaProducto.setCategoriaId(rs.getLong("categoria_id"));
            return categoriaProducto;
        }
    }
}
