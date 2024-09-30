package com.stylostore.stylo_store.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("my_super_secret_key_1234567890123456".getBytes()); // Clave secreta segura

    // Generar el token JWT
    public String generarToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas de validez
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // Firmar con clave secreta
                .compact();
    }

    // Extraer email del token JWT
    public String extraerEmail(String token) {
        return extraerClaims(token).getSubject();
    }

    // Validar el token JWT
    public boolean esTokenValido(String token, String email) {
        final String emailToken = extraerEmail(token);
        return (emailToken.equals(email) && !estaExpirado(token));
    }

    // Extraer todos los claims del token
    private Claims extraerClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Usar la clave secreta para verificar
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Verificar si el token ha expirado
    private boolean estaExpirado(String token) {
        return extraerClaims(token).getExpiration().before(new Date());
    }
}
