package com.generation.backend_02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.backend_02.model.Motorista;
import com.generation.backend_02.model.Usuario;

public interface MotoristaRepository extends JpaRepository<Motorista,Long>{
	
	public List<Motorista> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
