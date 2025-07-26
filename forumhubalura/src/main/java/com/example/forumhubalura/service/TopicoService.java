package com.example.forumhubalura.service;

import com.example.forumhubalura.domain.topico.Topico;
import com.example.forumhubalura.domain.topico.TopicoRepository;
import com.example.forumhubalura.domain.curso.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Topico atualizar(Long id, String novoTitulo, String novaMensagem) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        if (novoTitulo != null && !novoTitulo.isBlank()) {
            topico.setTitulo(novoTitulo);
        }
        if (novaMensagem != null && !novaMensagem.isBlank()) {
            topico.setMensagem(novaMensagem);
        }

        return topicoRepository.save(topico);
    }

    @Transactional
    public void excluir(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isEmpty()) {
            throw new RuntimeException("Tópico não encontrado");
        }
        topicoRepository.deleteById(id);
    }
}