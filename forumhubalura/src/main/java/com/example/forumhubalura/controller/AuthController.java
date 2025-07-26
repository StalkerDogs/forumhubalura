package com.example.forumhubalura.controller;

 import com.example.forumhubalura.domain.usuario.DadosAutenticacao;
 import com.example.forumhubalura.domain.usuario.Usuario;
 import com.example.forumhubalura.infra.security.DadosTokenJWT;
 import com.example.forumhubalura.infra.security.dto.TokenService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> autenticar(@RequestBody @Valid DadosAutenticacao dados) {
        var tokenAutenticacao = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        Authentication authentication = authenticationManager.authenticate(tokenAutenticacao);
        Usuario usuario = (Usuario) authentication.getPrincipal();
        String jwt = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosTokenJWT(jwt, "Bearer"));
    }
}