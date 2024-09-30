package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO usuario (nombres, apellidos, email, contraseña, rol_id) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_ALL_SQL = "SELECT * FROM usuario";
    private final String SELECT_BY_EMAIL_SQL = "SELECT * FROM usuario WHERE email = ?";
    private final String DELETE_BY_ID_SQL = "DELETE FROM usuario WHERE id = ?";

    public int insertarUsuario(Usuario usuario) {
        return jdbcTemplate.update(INSERT_SQL, usuario.getNombres(), usuario.getApellidos(), usuario.getEmail(), usuario.getContraseña(), usuario.getRol().getId());
    }

    public List<Usuario> obtenerTodos() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new UsuarioRowMapper());
    }

    public Usuario obtenerPorEmail(String email) {
        return jdbcTemplate.queryForObject(SELECT_BY_EMAIL_SQL, new UsuarioRowMapper(), email);
    }

    public int eliminarUsuario(Long id) {
        return jdbcTemplate.update(DELETE_BY_ID_SQL, id);
    }

    private static class UsuarioRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setNombres(rs.getString("nombres"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setEmail(rs.getString("email"));
            usuario.setContraseña(rs.getString("contraseña"));
            // Aquí deberías implementar la lógica para recuperar el rol basado en el rol_id
            return usuario;
        }
    }
}
