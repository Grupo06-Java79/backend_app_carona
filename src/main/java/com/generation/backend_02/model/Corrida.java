package com.generation.backend_02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_corrida")
public class Corrida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O Atributo distancia é Obrigatório!")
	private int distancia;
	
	@NotNull(message = "O Atributo velocidade é Obrigatório!")
	private int velocidade;
	
	private int tempoCorrida; // = distancia/velocidade  (inicio_corrida e termino_corrida)(horario_final - hora_inicio) 23:50 - 2:00 
	
	@Size(min = 3, max = 100, message = "Digite no min 5 e no maximo 10 caracteres")
	@NotNull(message = "O Atributo partida é Obrigatório!")
	private String partida;
	
	@Size(min = 3, max = 100, message = "Digite no min 5 e no maximo 10 caracteres")
	@NotNull(message = "O Atributo destino é Obrigatório!")
	private String destino;
	     
	@ManyToOne
	@JsonIgnoreProperties("usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("motorista")
	private Motorista motorista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getTempoCorrida() {
		return tempoCorrida;
	}

	public void setTempoCorrida(int tempoCorrida) {
		this.tempoCorrida = tempoCorrida;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	
}
