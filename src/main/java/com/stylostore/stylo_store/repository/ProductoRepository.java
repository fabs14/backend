package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO producto (nombre, descripcion, precio) VALUES (?, ?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM producto";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM producto WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM producto WHERE id = ?";

    // Insertar nuevo producto
    public int insertarProducto(Producto producto) {
        return jdbcTemplate.update(INSERT_SQL, producto.getNombre(), producto.getDescripcion(), producto.getPrecio());
    }

    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new ProductoRowMapper());
    }

    // Obtener producto por ID
    public Producto obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new ProductoRowMapper(), id);
    }

    // Actualizar producto
    public int actualizarProducto(Long id, Producto producto) {
        return jdbcTemplate.update(UPDATE_SQL, producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), id);
    }

    // Eliminar producto
    public int eliminarProducto(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapper para convertir ResultSet a objeto Producto
    private static class ProductoRowMapper implements RowMapper<Producto> {
        @Override
        public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Producto producto = new Producto();
            producto.setId(rs.getLong("id"));
            producto.setNombre(rs.getString("nombre"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecio(rs.getDouble("precio"));
            return producto;
        }
    }
}
