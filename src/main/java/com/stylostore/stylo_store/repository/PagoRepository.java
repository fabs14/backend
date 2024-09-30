package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PagoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO pago (horaPago, montoTotal, metodoPago_id) VALUES (?, ?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM pago";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM pago WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE pago SET horaPago = ?, montoTotal = ?, metodoPago_id = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM pago WHERE id = ?";

    // Insertar nuevo pago
    public int insertarPago(Pago pago) {
        return jdbcTemplate.update(INSERT_SQL, pago.getHoraPago(), pago.getMontoTotal(), pago.getMetodoPagoId());
    }

    // Obtener todos los pagos
    public List<Pago> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new PagoRowMapper());
    }

    // Obtener pago por ID
    public Pago obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new PagoRowMapper(), id);
    }

    // Actualizar pago
    public int actualizarPago(Long id, Pago pago) {
        return jdbcTemplate.update(UPDATE_SQL, pago.getHoraPago(), pago.getMontoTotal(), pago.getMetodoPagoId(), id);
    }

    // Eliminar pago
    public int eliminarPago(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Pago
    private static class PagoRowMapper implements RowMapper<Pago> {
        @Override
        public Pago mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pago pago = new Pago();
            pago.setId(rs.getLong("id"));
            pago.setFechaPago(rs.getTimestamp("fechaPago").toLocalDateTime());
            pago.setHoraPago(rs.getTime("horaPago").toLocalTime());
            pago.setMontoTotal(rs.getDouble("montoTotal"));
            pago.setMetodoPagoId(rs.getLong("metodoPago_id"));
            return pago;
        }
    }
}
