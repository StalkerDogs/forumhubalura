package com.example.forumhubalura.controller;

import com.example.forumhubalura.domain.topico.Topico;
import com.example.forumhubalura.domain.topico.TopicoRepository;
import com.example.forumhubalura.domain.curso.CursoRepository;
import com.example.forumhubalura.domain.usuario.Usuario; // Import the Usuario class
import com.example.forumhubalura.domain.curso.Curso; // Import the Curso class

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

    @PostMapping
    public ResponseEntity<Map<String, Object>> cadastrar(@RequestBody Map<String, Object> dados,
                                                         @AuthenticationPrincipal Usuario autor) {
        var titulo = (String) dados.get("titulo");
        var mensagem = (String) dados.get("mensagem");
        var nomeCurso = (String) dados.get("nomeDoCurso");
        var dataCriacaoStr = (String) dados.get("dataCriacao");

        Curso curso = cursoRepository.findByNome(nomeCurso)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado: " + nomeCurso));

        var dataCriacao = LocalDateTime.parse(dataCriacaoStr, formatter);

        var topico = new Topico(titulo, mensagem, autor, curso);
        topico.setDataCriacao(dataCriacao);
        topico = topicoRepository.save(topico);

        var response = new LinkedHashMap<String, Object>();
        response.put("id", topico.getId());
        response.put("titulo", topico.getTitulo());
        response.put("mensagem", topico.getMensagem());
        response.put("nomeDoCurso", curso.getNome());
        response.put("dataCriacao", topico.getDataCriacao());

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<LinkedHashMap<String, Object>>> listar() {
        var lista = topicoRepository.findAll().stream().map(topico -> {
            var item = new LinkedHashMap<String, Object>();
            item.put("id", topico.getId());
            item.put("titulo", topico.getTitulo());
            item.put("mensagem", topico.getMensagem());
            item.put("nomeDoCurso", topico.getCurso().getNome());
            item.put("dataCriacao", topico.getDataCriacao());
            return item;
        }).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscarPorId(@PathVariable Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        var response = new LinkedHashMap<String, Object>();
        response.put("id", topico.getId());
        response.put("titulo", topico.getTitulo());
        response.put("mensagem", topico.getMensagem());
        response.put("nomeDoCurso", topico.getCurso().getNome());
        response.put("dataCriacao", topico.getDataCriacao());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id,
                                                         @RequestBody Map<String, Object> dados) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        if (dados.get("titulo") != null) topico.setTitulo((String) dados.get("titulo"));
        if (dados.get("mensagem") != null) topico.setMensagem((String) dados.get("mensagem"));

        topicoRepository.save(topico);

        var response = new LinkedHashMap<String, Object>();
        response.put("id", topico.getId());
        response.put("titulo", topico.getTitulo());
        response.put("mensagem", topico.getMensagem());
        response.put("nomeDoCurso", topico.getCurso().getNome());
        response.put("dataCriacao", topico.getDataCriacao());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}