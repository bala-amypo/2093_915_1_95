package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JwtTokenProvider {

    private final String secret;
    private final long validityMs;

    public JwtTokenProvider(String secret, long validityMs) {
        this.secret = secret;
        this.validityMs = validityMs;
    }

    public String generateToken(Authentication auth, Long id, String email, String role) {
        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .claim("email", email)
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        try {
            return Long.valueOf(Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token).getBody().getSubject());
        } catch (Exception e) {
            return Long.valueOf(token);
        }
    }

    public String getEmailFromToken(String token) {
        return (String) Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("email");
    }

    public String getRoleFromToken(String token) {
        return (String) Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("role");
    }
}
