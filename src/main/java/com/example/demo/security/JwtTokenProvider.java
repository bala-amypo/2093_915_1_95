package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtTokenProvider {

    private final Key key;
    private final long expiry;

    public JwtTokenProvider(String secret, long expiry) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiry = expiry;
    }

    public String generateToken(Authentication auth, Long id, String email, String role) {
        return Jwts.builder()
                .claim("userId", id)
                .claim("email", email)
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try { Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token); return true; }
        catch (Exception e) { return false; }
    }

    public Long getUserIdFromToken(String token) {
        Claims c = Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody();
        return c.get("userId", Long.class) != null ?
                c.get("userId", Long.class) :
                Long.valueOf(c.getSubject());
    }

    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().get("email", String.class);
    }

    public String getRoleFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().get("role", String.class);
    }
}
