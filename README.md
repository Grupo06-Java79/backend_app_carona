# backend_02
Projeto 02 do Grupo 06 da Turma 79 Java do Bootcamp Generation

INTEGRANTES
<br>Guilherme Kaludin
<br>João Oliveira
<br>Juliana Monteiro
<br>Lucas Daniel
<br>Tainá Lara


PROJETO INTEGRADOR
ESCOPO DO PROJETO

Tema: Aplicativo de caronas compartilhadas

Título do Projeto e Modelo de Negócio escolhido:  
<br>Aplicativo de caronas compartilhadas

Descrição Geral do Projeto: 
<br>O projeto aplicativo de caronas é uma aplicação desenvolvida em Spring Boot que gerencia as operações relacionadas a corridas realizadas por usuários e motoristas. 

Descrição da Entidade/Model foi criada e seus atributos: 
<br>Criamos as Model’s Usuário, Corrida e Motorista.
<br>(tb_usuario) com os atributos id, nome, email e telefone.
<br>(tb_corrida) com os atributos id, distancia, velocidade, tempoCorrida, partida, destino e FK id usuario e id motorista.
<br>(tb_motorista) com os atributos id, nome e tipoVeiculo.


Funcionalidades Principais (CRUD) implementadas
<br>Criamos as seguintes funcionalidades:
<br>Método utilitário para formatar o tempo em hh:mm:ss
<br>formatarTempo()
<br>findAll()
<br>findById()
<br>post()
<br>put()
<br>delete()
<br>findAllByNome

Tecnologias Utilizadas (banco de dados e backend):
<br> Java 17+
<br>MySql Driver
<br>Spring Boot Dev Tools
<br>SpringWeb
<br>Validation
<br>Spring Data JPA




