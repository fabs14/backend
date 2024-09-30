package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.DetalleReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DetalleReservaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO detallereserva (reserva_id, producto_id, talla_id, cantidad) VALUES (?, ?, ?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM detallereserva";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM detallereserva WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE detallereserva SET reserva_id = ?, producto_id = ?, talla_id = ?, cantidad = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM detallereserva WHERE id = ?";

    // Insertar nuevo detalle de reserva
    public int insertarDetalleReserva(DetalleReserva detalleReserva) {
        return jdbcTemplate.update(INSERT_SQL, detalleReserva.getReservaId(), detalleReserva.getProductoId(), detalleReserva.getTallaId(), detalleReserva.getCantidad());
    }

    // Obtener todos los detalles de reserva
    public List<DetalleReserva> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new DetalleReservaRowMapper());
    }

    // Obtener detalle de reserva por ID
    public DetalleReserva obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new DetalleReservaRowMapper(), id);
    }

    // Actualizar detalle de reserva
    public int actualizarDetalleReserva(Long id, DetalleReserva detalleReserva) {
        return jdbcTemplate.update(UPDATE_SQL, detalleReserva.getReservaId(), detalleReserva.getProductoId(), detalleReserva.getTallaId(), detalleReserva.getCantidad(), id);
    }

    // Eliminar detalle de reserva
    public int eliminarDetalleReserva(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto DetalleReserva
    private static class DetalleReservaRowMapper implements RowMapper<DetalleReserva> {
        @Override
        public DetalleReserva mapRow(ResultSet rs, int rowNum) throws SQLException {
            DetalleReserva detalleReserva = new DetalleReserva();
            detalleReserva.setId(rs.getLong("id"));
            detalleReserva.setReservaId(rs.getLong("reserva_id"));
            detalleReserva.setProductoId(rs.getLong("producto_id"));
            detalleReserva.setTallaId(rs.getLong("talla_id"));
            detalleReserva.setCantidad(rs.getInt("cantidad"));
            return detalleReserva;
        }
    }
}
