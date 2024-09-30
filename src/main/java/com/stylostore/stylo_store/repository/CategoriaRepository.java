package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoriaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO categoria (nombre) VALUES (?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM categoria";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM categoria WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE categoria SET nombre = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM categoria WHERE id = ?";

    // Insertar nueva categoría
    public int insertarCategoria(Categoria categoria) {
        return jdbcTemplate.update(INSERT_SQL, categoria.getNombre());
    }

    // Obtener todas las categorías
    public List<Categoria> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new CategoriaRowMapper());
    }

    // Obtener categoría por ID
    public Categoria obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new CategoriaRowMapper(), id);
    }

    // Actualizar categoría
    public int actualizarCategoria(Long id, Categoria categoria) {
        return jdbcTemplate.update(UPDATE_SQL, categoria.getNombre(), id);
    }

    // Eliminar categoría
    public int eliminarCategoria(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Categoria
    private static class CategoriaRowMapper implements RowMapper<Categoria> {
        @Override
        public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong("id"));
            categoria.setNombre(rs.getString("nombre"));
            return categoria;
        }
    }
}
