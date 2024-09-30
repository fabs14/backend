package com.stylostore.stylo_store.repository;

import com.stylostore.stylo_store.model.Usuario;
import com.stylostore.stylo_store.model.Rol;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getLong("id"));
        usuario.setNombres(rs.getString("nombres"));
        usuario.setApellidos(rs.getString("apellidos"));
        usuario.setEmail(rs.getString("email"));
        usuario.setContraseña(rs.getString("contraseña"));

        // Suponiendo que el rol_id es un FK que apunta a la tabla de roles
        Rol rol = new Rol();
        rol.setId(rs.getLong("rol_id"));
        // También podrías cargar el nombre del rol si es necesario
        usuario.setRol(rol);

        return usuario;
    }
}
