package com.generation.backend_02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.backend_02.model.Corrida;
import com.generation.backend_02.service.CorridaService;

@RestController
@RequestMapping("/corridas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CorridaController {
	
	private final CorridaService corridaService;

    public CorridaController(CorridaService corridaService) {
        this.corridaService = corridaService;
    }

    // Criar uma nova corrida
    @PostMapping
    public ResponseEntity<Corrida> criarCorrida(@RequestBody Corrida corrida) {
        try {
            Corrida novaCorrida = corridaService.salvarCorrida(corrida);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaCorrida);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Buscar todas as corridas
    @GetMapping
    public ResponseEntity<List<Corrida>> listarCorridas() {
        List<Corrida> corridas = corridaService.listarCorridas();
        return ResponseEntity.ok(corridas);
    }

    // Buscar corrida por ID
    @GetMapping("/{id}")
    public ResponseEntity<Corrida> buscarCorridaPorId(@PathVariable Long id) {
        Optional<Corrida> corrida = corridaService.buscarCorridaPorId(id);
        return corrida.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Atualizar corrida
    @PutMapping("/{id}")
    public ResponseEntity<Corrida> atualizarCorrida(@PathVariable Long id, @RequestBody Corrida corridaAtualizada) {
        try {
            Corrida corrida = corridaService.atualizarCorrida(id, corridaAtualizada);
            return ResponseEntity.ok(corrida);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Excluir corrida por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCorrida(@PathVariable Long id) {
        try {
            corridaService.excluirCorrida(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	
}
