package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.ProductoTallaInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoTallaInventarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO productotallainventario (producto_id, talla_id, cantidad) VALUES (?, ?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM productotallainventario";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM productotallainventario WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE productotallainventario SET producto_id = ?, talla_id = ?, cantidad = ?, fechaActualizacion = CURRENT_TIMESTAMP WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM productotallainventario WHERE id = ?";

    // Insertar nuevo registro de inventario
    public int insertarProductoTallaInventario(ProductoTallaInventario inventario) {
        return jdbcTemplate.update(INSERT_SQL, inventario.getProductoId(), inventario.getTallaId(), inventario.getCantidad());
    }

    // Obtener todos los registros de inventario
    public List<ProductoTallaInventario> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new ProductoTallaInventarioRowMapper());
    }

    // Obtener inventario por ID
    public ProductoTallaInventario obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new ProductoTallaInventarioRowMapper(), id);
    }

    // Actualizar inventario
    public int actualizarProductoTallaInventario(Long id, ProductoTallaInventario inventario) {
        return jdbcTemplate.update(UPDATE_SQL, inventario.getProductoId(), inventario.getTallaId(), inventario.getCantidad(), id);
    }

    // Eliminar inventario
    public int eliminarProductoTallaInventario(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto ProductoTallaInventario
    private static class ProductoTallaInventarioRowMapper implements RowMapper<ProductoTallaInventario> {
        @Override
        public ProductoTallaInventario mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProductoTallaInventario inventario = new ProductoTallaInventario();
            inventario.setId(rs.getLong("id"));
            inventario.setProductoId(rs.getLong("producto_id"));
            inventario.setTallaId(rs.getLong("talla_id"));
            inventario.setCantidad(rs.getInt("cantidad"));
            inventario.setFechaActualizacion(rs.getTimestamp("fechaActualizacion").toLocalDateTime());
            return inventario;
        }
    }
}
