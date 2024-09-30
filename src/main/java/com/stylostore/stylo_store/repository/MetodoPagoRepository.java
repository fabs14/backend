package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.MetodoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MetodoPagoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO metodopago (nombreMetodo) VALUES (?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM metodopago";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM metodopago WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE metodopago SET nombreMetodo = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM metodopago WHERE id = ?";

    // Insertar nuevo método de pago
    public int insertarMetodoPago(MetodoPago metodoPago) {
        return jdbcTemplate.update(INSERT_SQL, metodoPago.getNombreMetodo());
    }

    // Obtener todos los métodos de pago
    public List<MetodoPago> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new MetodoPagoRowMapper());
    }

    // Obtener método de pago por ID
    public MetodoPago obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new MetodoPagoRowMapper(), id);
    }

    // Actualizar método de pago
    public int actualizarMetodoPago(Long id, MetodoPago metodoPago) {
        return jdbcTemplate.update(UPDATE_SQL, metodoPago.getNombreMetodo(), id);
    }

    // Eliminar método de pago
    public int eliminarMetodoPago(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto MetodoPago
    private static class MetodoPagoRowMapper implements RowMapper<MetodoPago> {
        @Override
        public MetodoPago mapRow(ResultSet rs, int rowNum) throws SQLException {
            MetodoPago metodoPago = new MetodoPago();
            metodoPago.setId(rs.getLong("id"));
            metodoPago.setNombreMetodo(rs.getString("nombreMetodo"));
            return metodoPago;
        }
    }
}
