package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PermisoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO permisos (nombre) VALUES (?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM permisos";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM permisos WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE permisos SET nombre = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM permisos WHERE id = ?";

    // Insertar permiso
    public int insertarPermiso(Permiso permiso) {
        return jdbcTemplate.update(INSERT_SQL, permiso.getNombre());
    }

    // Obtener todos los permisos
    public List<Permiso> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new PermisoRowMapper());
    }

    // Obtener permiso por ID
    public Permiso obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new PermisoRowMapper(), id);
    }

    // Actualizar permiso
    public int actualizarPermiso(Long id, Permiso permiso) {
        return jdbcTemplate.update(UPDATE_SQL, permiso.getNombre(), id);
    }

    // Eliminar permiso
    public int eliminarPermiso(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Permiso
    private static class PermisoRowMapper implements RowMapper<Permiso> {
        @Override
        public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
            Permiso permiso = new Permiso();
            permiso.setId(rs.getLong("id"));
            permiso.setNombre(rs.getString("nombre"));
            return permiso;
        }
    }
}
