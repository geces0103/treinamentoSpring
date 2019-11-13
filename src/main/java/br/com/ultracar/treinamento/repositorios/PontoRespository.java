package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Cidade;
import br.com.ultracar.treinamento.entidades.Ponto;

@Repository
public interface PontoRespository extends JpaRepository<Ponto, Long> {
	
	
}