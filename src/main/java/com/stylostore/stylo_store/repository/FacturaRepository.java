package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FacturaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO factura (pedido_id, nombreCliente, nit, total) VALUES (?, ?, ?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM factura";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM factura WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE factura SET pedido_id = ?, nombreCliente = ?, nit = ?, total = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM factura WHERE id = ?";

    // Insertar nueva factura
    public int insertarFactura(Factura factura) {
        return jdbcTemplate.update(INSERT_SQL, factura.getPedidoId(), factura.getNombreCliente(), factura.getNit(), factura.getTotal());
    }

    // Obtener todas las facturas
    public List<Factura> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new FacturaRowMapper());
    }

    // Obtener factura por ID
    public Factura obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new FacturaRowMapper(), id);
    }

    // Actualizar factura
    public int actualizarFactura(Long id, Factura factura) {
        return jdbcTemplate.update(UPDATE_SQL, factura.getPedidoId(), factura.getNombreCliente(), factura.getNit(), factura.getTotal(), id);
    }

    // Eliminar factura
    public int eliminarFactura(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Factura
    private static class FacturaRowMapper implements RowMapper<Factura> {
        @Override
        public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
            Factura factura = new Factura();
            factura.setId(rs.getLong("id"));
            factura.setPedidoId(rs.getLong("pedido_id"));
            factura.setNombreCliente(rs.getString("nombreCliente"));
            factura.setNit(rs.getString("nit"));
            factura.setFechaEmision(rs.getTimestamp("fechaEmision").toLocalDateTime());
            factura.setTotal(rs.getDouble("total"));
            return factura;
        }
    }
}
