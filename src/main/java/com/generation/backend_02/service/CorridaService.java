package com.generation.backend_02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.generation.backend_02.model.Corrida;
import com.generation.backend_02.repository.CorridaRepository;

@Service
public class CorridaService {

    private final CorridaRepository corridaRepository;

    public CorridaService(CorridaRepository corridaRepository) {
        this.corridaRepository = corridaRepository;
    }

  
    public Corrida salvarCorrida(Corrida corrida) {
        calcularTempoCorrida(corrida); // Calcula o tempo antes de salvar
        return corridaRepository.save(corrida);
    }

    
    public List<Corrida> listarCorridas() {
        return corridaRepository.findAll();
    }

    public Optional<Corrida> buscarCorridaPorId(Long id) {
        return corridaRepository.findById(id);
    }

    
    public Corrida atualizarCorrida(Long id, Corrida corridaAtualizada) {
        return corridaRepository.findById(id)
                .map(corrida -> {
                    corrida.setDistancia(corridaAtualizada.getDistancia());
                    corrida.setVelocidade(corridaAtualizada.getVelocidade());
                    corrida.setPartida(corridaAtualizada.getPartida());
                    corrida.setDestino(corridaAtualizada.getDestino());
                    corrida.setUsuario(corridaAtualizada.getUsuario());
                    corrida.setMotorista(corridaAtualizada.getMotorista());
                    calcularTempoCorrida(corrida); // Recalcula o tempo ao atualizar
                    return corridaRepository.save(corrida);
                })
                .orElseThrow(() -> new RuntimeException("Corrida não encontrada!"));
    }

    
    public void excluirCorrida(Long id) {
        corridaRepository.deleteById(id);
    }

    // Calcular o tempo da corrida (em segundos e formatado)
    private void calcularTempoCorrida(Corrida corrida) {
        if (corrida.getDistancia() != null && corrida.getVelocidade() != null && corrida.getVelocidade() > 0) {
            double tempoEmHoras = corrida.getDistancia() / corrida.getVelocidade();
            long tempoEmSegundos = Math.round(tempoEmHoras * 3600); // Converte para segundos
            corrida.setTempoCorrida(tempoEmSegundos); // Define o tempo em segundos e já formata
        } else {
            throw new IllegalArgumentException("Distância e velocidade devem ser válidas para calcular o tempo da corrida.");
        }
    }
}

