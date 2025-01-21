package com.generation.backend_02.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_corrida")
public class Corrida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double distancia;
    private Double velocidade;
    private Long tempoCorrida; // Tempo em segundos

   
    private String tempoFormatado; // Tempo formatado como hh:mm:ss

    private String partida;
    private String destino;

    @ManyToOne()
    @JsonIgnoreProperties("corrida")
    /*Esta anotação é usada sempre pelo lado que depende da informação, nunca pelo lugar
    que detém a informação, pois lá, a informação necessita ser serializada normalmente.
    Casos complexos, programar a serialização ou utilizar um padrão chamado DTO. */
	private Usuario usuario;
	
    @ManyToOne()
    @JsonIgnoreProperties("corrida") 
    /*Esta anotação é usada sempre pelo lado que depende da informação, nunca pelo lugar
    que detém a informação, pois lá, a informação necessita ser serializada normalmente.
    Casos complexos, programar a serialização ou utilizar um padrão chamado DTO. */
	private Motorista motorista;


    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Long getTempoCorrida() {
        return tempoCorrida;
    }

    public void setTempoCorrida(Long tempoCorrida) {
        this.tempoCorrida = tempoCorrida;
        this.tempoFormatado = formatarTempo(tempoCorrida);
    }

    public String getTempoFormatado() {
        return tempoFormatado;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getPartida() {
        return partida;
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

    // Método utilitário para formatar o tempo em hh:mm:ss
    private String formatarTempo(Long tempoEmSegundos) {
        if (tempoEmSegundos == null) {
            return null;
        }
        long horas = tempoEmSegundos / 3600;
        long minutos = (tempoEmSegundos % 3600) / 60;
        long segundos = tempoEmSegundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
	     
	
	
	
	

