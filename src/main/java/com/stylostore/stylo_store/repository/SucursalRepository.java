package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SucursalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO sucursal (nombreSucursal, direccionSucursal) VALUES (?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM sucursal";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM sucursal WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE sucursal SET nombreSucursal = ?, direccionSucursal = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM sucursal WHERE id = ?";

    // Insertar nueva sucursal
    public int insertarSucursal(Sucursal sucursal) {
        return jdbcTemplate.update(INSERT_SQL, sucursal.getNombreSucursal(), sucursal.getDireccionSucursal());
    }

    // Obtener todas las sucursales
    public List<Sucursal> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new SucursalRowMapper());
    }

    // Obtener sucursal por ID
    public Sucursal obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new SucursalRowMapper(), id);
    }

    // Actualizar sucursal
    public int actualizarSucursal(Long id, Sucursal sucursal) {
        return jdbcTemplate.update(UPDATE_SQL, sucursal.getNombreSucursal(), sucursal.getDireccionSucursal(), id);
    }

    // Eliminar sucursal
    public int eliminarSucursal(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Sucursal
    private static class SucursalRowMapper implements RowMapper<Sucursal> {
        @Override
        public Sucursal mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sucursal sucursal = new Sucursal();
            sucursal.setId(rs.getLong("id"));
            sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
            sucursal.setDireccionSucursal(rs.getString("direccionSucursal"));
            return sucursal;
        }
    }
}
