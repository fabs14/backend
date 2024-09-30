package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO reserva (usuario_id, fechaExpiracion) VALUES (?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM reserva";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM reserva WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE reserva SET usuario_id = ?, fechaExpiracion = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM reserva WHERE id = ?";

    // Insertar nueva reserva
    public int insertarReserva(Reserva reserva) {
        return jdbcTemplate.update(INSERT_SQL, reserva.getUsuarioId(), reserva.getFechaExpiracion());
    }

    // Obtener todas las reservas
    public List<Reserva> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new ReservaRowMapper());
    }

    // Obtener reserva por ID
    public Reserva obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new ReservaRowMapper(), id);
    }

    // Actualizar reserva
    public int actualizarReserva(Long id, Reserva reserva) {
        return jdbcTemplate.update(UPDATE_SQL, reserva.getUsuarioId(), reserva.getFechaExpiracion(), id);
    }

    // Eliminar reserva
    public int eliminarReserva(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Reserva
    private static class ReservaRowMapper implements RowMapper<Reserva> {
        @Override
        public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reserva reserva = new Reserva();
            reserva.setId(rs.getLong("id"));
            reserva.setUsuarioId(rs.getLong("usuario_id"));
            reserva.setFechaReserva(rs.getTimestamp("fechaReserva").toLocalDateTime());
            reserva.setFechaExpiracion(rs.getTimestamp("fechaExpiracion").toLocalDateTime());
            return reserva;
        }
    }
}
