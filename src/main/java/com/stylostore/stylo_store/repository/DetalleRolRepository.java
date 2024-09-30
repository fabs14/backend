package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.DetalleRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DetalleRolRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO detallerol (rol_id, permiso_id) VALUES (?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM detallerol";
    private final String SELECT_BY_ROL_SQL = "SELECT * FROM detallerol WHERE rol_id = ?";
    private final String DELETE_SQL = "DELETE FROM detallerol WHERE id = ?";

    // Insertar DetalleRol (relación entre Rol y Permiso)
    public int insertarDetalleRol(DetalleRol detalleRol) {
        return jdbcTemplate.update(INSERT_SQL, detalleRol.getRolId(), detalleRol.getPermisoId());
    }

    // Obtener todas las relaciones
    public List<DetalleRol> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new DetalleRolRowMapper());
    }

    // Obtener relaciones por ID de Rol
    public List<DetalleRol> obtenerPorRolId(Long rolId) {
        return jdbcTemplate.query(SELECT_BY_ROL_SQL, new DetalleRolRowMapper(), rolId);
    }

    // Eliminar DetalleRol por ID
    public int eliminarDetalleRol(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto DetalleRol
    private static class DetalleRolRowMapper implements RowMapper<DetalleRol> {
        @Override
        public DetalleRol mapRow(ResultSet rs, int rowNum) throws SQLException {
            DetalleRol detalleRol = new DetalleRol();
            detalleRol.setId(rs.getLong("id"));
            detalleRol.setRolId(rs.getLong("rol_id"));
            detalleRol.setPermisoId(rs.getLong("permiso_id"));
            return detalleRol;
        }
    }
}
