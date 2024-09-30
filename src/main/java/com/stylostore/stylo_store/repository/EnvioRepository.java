package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Envio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EnvioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO envio (pedido_id, delivery_id, sucursal_id, direccionEntrega_id, horaSalida) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM envio";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM envio WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE envio SET pedido_id = ?, delivery_id = ?, sucursal_id = ?, direccionEntrega_id = ?, horaSalida = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM envio WHERE id = ?";

    // Insertar nuevo envío
    public int insertarEnvio(Envio envio) {
        return jdbcTemplate.update(INSERT_SQL, envio.getPedidoId(), envio.getDeliveryId(), envio.getSucursalId(), envio.getDireccionEntregaId(), envio.getHoraSalida());
    }

    // Obtener todos los envíos
    public List<Envio> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new EnvioRowMapper());
    }

    // Obtener envío por ID
    public Envio obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new EnvioRowMapper(), id);
    }

    // Actualizar envío
    public int actualizarEnvio(Long id, Envio envio) {
        return jdbcTemplate.update(UPDATE_SQL, envio.getPedidoId(), envio.getDeliveryId(), envio.getSucursalId(), envio.getDireccionEntregaId(), envio.getHoraSalida(), id);
    }

    // Eliminar envío
    public int eliminarEnvio(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Envio
    private static class EnvioRowMapper implements RowMapper<Envio> {
        @Override
        public Envio mapRow(ResultSet rs, int rowNum) throws SQLException {
            Envio envio = new Envio();
            envio.setId(rs.getLong("id"));
            envio.setPedidoId(rs.getLong("pedido_id"));
            envio.setDeliveryId(rs.getLong("delivery_id"));
            envio.setSucursalId(rs.getLong("sucursal_id"));
            envio.setDireccionEntregaId(rs.getLong("direccionEntrega_id"));
            envio.setFechaSalida(rs.getTimestamp("fechaSalida").toLocalDateTime());
            envio.setHoraSalida(rs.getTime("horaSalida").toLocalTime());
            return envio;
        }
    }
}
