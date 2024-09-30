package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RolRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO rol (nombre) VALUES (?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM rol";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM rol WHERE id = ?";
    private final String UPDATE_SQL = "UPDATE rol SET nombre = ? WHERE id = ?";
    private final String DELETE_SQL = "DELETE FROM rol WHERE id = ?";

    // Insertar un nuevo rol
    public int insertarRol(Rol rol) {
        return jdbcTemplate.update(INSERT_SQL, rol.getNombre());
    }

    // Obtener todos los roles
    public List<Rol> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new RolRowMapper());
    }

    // Obtener un rol por ID
    public Rol obtenerPorId(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new RolRowMapper(), id);
    }

    // Actualizar un rol
    public int actualizarRol(Rol rol) {
        return jdbcTemplate.update(UPDATE_SQL, rol.getNombre(), rol.getId());
    }

    // Eliminar un rol
    public int eliminarRol(Long id) {
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    // Mapeador de filas para la entidad Rol
    private static class RolRowMapper implements RowMapper<Rol> {
        @Override
        public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
            Rol rol = new Rol();
            rol.setId(rs.getLong("id"));
            rol.setNombre(rs.getString("nombre"));
            return rol;
        }
    }
}
