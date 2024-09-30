package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.DireccionEntrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DireccionEntregaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO direccionentrega (direccion, aliasDireccion) VALUES (?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM direccionentrega";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM direccionentrega WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE direccionentrega SET direccion = ?, aliasDireccion = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM direccionentrega WHERE id = ?";

    // Insertar nueva dirección de entrega
    public int insertarDireccionEntrega(DireccionEntrega direccionEntrega) {
        return jdbcTemplate.update(INSERT_SQL, direccionEntrega.getDireccion(), direccionEntrega.getAliasDireccion());
    }

    // Obtener todas las direcciones de entrega
    public List<DireccionEntrega> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new DireccionEntregaRowMapper());
    }

    // Obtener dirección de entrega por ID
    public DireccionEntrega obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new DireccionEntregaRowMapper(), id);
    }

    // Actualizar dirección de entrega
    public int actualizarDireccionEntrega(Long id, DireccionEntrega direccionEntrega) {
        return jdbcTemplate.update(UPDATE_SQL, direccionEntrega.getDireccion(), direccionEntrega.getAliasDireccion(), id);
    }

    // Eliminar dirección de entrega
    public int eliminarDireccionEntrega(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto DireccionEntrega
    private static class DireccionEntregaRowMapper implements RowMapper<DireccionEntrega> {
        @Override
        public DireccionEntrega mapRow(ResultSet rs, int rowNum) throws SQLException {
            DireccionEntrega direccionEntrega = new DireccionEntrega();
            direccionEntrega.setId(rs.getLong("id"));
            direccionEntrega.setDireccion(rs.getString("direccion"));
            direccionEntrega.setAliasDireccion(rs.getString("aliasDireccion"));
            return direccionEntrega;
        }
    }
}
