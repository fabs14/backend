package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Talla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TallaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO talla (nombre, descripcion) VALUES (?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM talla";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM talla WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE talla SET nombre = ?, descripcion = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM talla WHERE id = ?";

    // Insertar nueva talla
    public int insertarTalla(Talla talla) {
        return jdbcTemplate.update(INSERT_SQL, talla.getNombre(), talla.getDescripcion());
    }

    // Obtener todas las tallas
    public List<Talla> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new TallaRowMapper());
    }

    // Obtener talla por ID
    public Talla obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new TallaRowMapper(), id);
    }

    // Actualizar talla
    public int actualizarTalla(Long id, Talla talla) {
        return jdbcTemplate.update(UPDATE_SQL, talla.getNombre(), talla.getDescripcion(), id);
    }

    // Eliminar talla
    public int eliminarTalla(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Talla
    private static class TallaRowMapper implements RowMapper<Talla> {
        @Override
        public Talla mapRow(ResultSet rs, int rowNum) throws SQLException {
            Talla talla = new Talla();
            talla.setId(rs.getLong("id"));
            talla.setNombre(rs.getString("nombre"));
            talla.setDescripcion(rs.getString("descripcion"));
            return talla;
        }
    }
}
