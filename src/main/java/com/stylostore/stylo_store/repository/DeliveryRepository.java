package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DeliveryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO delivery (nombreEmpleado) VALUES (?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM delivery";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM delivery WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE delivery SET nombreEmpleado = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM delivery WHERE id = ?";

    // Insertar nuevo delivery
    public int insertarDelivery(Delivery delivery) {
        return jdbcTemplate.update(INSERT_SQL, delivery.getNombreEmpleado());
    }

    // Obtener todos los deliveries
    public List<Delivery> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new DeliveryRowMapper());
    }

    // Obtener delivery por ID
    public Delivery obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new DeliveryRowMapper(), id);
    }

    // Actualizar delivery
    public int actualizarDelivery(Long id, Delivery delivery) {
        return jdbcTemplate.update(UPDATE_SQL, delivery.getNombreEmpleado(), id);
    }

    // Eliminar delivery
    public int eliminarDelivery(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Delivery
    private static class DeliveryRowMapper implements RowMapper<Delivery> {
        @Override
        public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
            Delivery delivery = new Delivery();
            delivery.setId(rs.getLong("id"));
            delivery.setNombreEmpleado(rs.getString("nombreEmpleado"));
            return delivery;
        }
    }
}
