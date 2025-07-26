package com.example.forumhubalura.infra.security;

public record DadosTokenJWT(
        String token,
        String tipo
) {}