package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DetallePedidoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO detallepedido (pedido_id, producto_id, talla_id, cantidad) VALUES (?, ?, ?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM detallepedido";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM detallepedido WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE detallepedido SET pedido_id = ?, producto_id = ?, talla_id = ?, cantidad = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM detallepedido WHERE id = ?";

    // Insertar nuevo detalle de pedido
    public int insertarDetallePedido(DetallePedido detallePedido) {
        return jdbcTemplate.update(INSERT_SQL, detallePedido.getPedidoId(), detallePedido.getProductoId(), detallePedido.getTallaId(), detallePedido.getCantidad());
    }

    // Obtener todos los detalles de pedido
    public List<DetallePedido> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new DetallePedidoRowMapper());
    }

    // Obtener detalle de pedido por ID
    public DetallePedido obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new DetallePedidoRowMapper(), id);
    }

    // Actualizar detalle de pedido
    public int actualizarDetallePedido(Long id, DetallePedido detallePedido) {
        return jdbcTemplate.update(UPDATE_SQL, detallePedido.getPedidoId(), detallePedido.getProductoId(), detallePedido.getTallaId(), detallePedido.getCantidad(), id);
    }

    // Eliminar detalle de pedido
    public int eliminarDetallePedido(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto DetallePedido
    private static class DetallePedidoRowMapper implements RowMapper<DetallePedido> {
        @Override
        public DetallePedido mapRow(ResultSet rs, int rowNum) throws SQLException {
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setId(rs.getLong("id"));
            detallePedido.setPedidoId(rs.getLong("pedido_id"));
            detallePedido.setProductoId(rs.getLong("producto_id"));
            detallePedido.setTallaId(rs.getLong("talla_id"));
            detallePedido.setCantidad(rs.getInt("cantidad"));
            return detallePedido;
        }
    }
}
