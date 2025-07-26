package com.example.forumhubalura.infra.security.dto;

import com.example.forumhubalura.domain.usuario.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret;

    private Key chaveAssinatura;

    @PostConstruct
    public void init() {
        this.chaveAssinatura = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setIssuer("ForumHub")
                .setSubject(usuario.getLogin())
                .setIssuedAt(new Date())
                .setExpiration(dataDeExpiracao())
                .signWith(chaveAssinatura, SignatureAlgorithm.HS256)
                .compact();
    }


    public String validarToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(chaveAssinatura)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (JwtException e) {
            throw new RuntimeException("Token inválido ou expirado.");
        }
    }

    private Date dataDeExpiracao() {
        return Date.from(
                LocalDateTime.now()
                        .plusHours(2)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
    }
}