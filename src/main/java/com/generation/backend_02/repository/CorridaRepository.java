package com.generation.backend_02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.backend_02.model.Corrida;

public interface CorridaRepository extends JpaRepository<Corrida,Long>{

	public List <Corrida> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
