package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Bairro;
import br.com.ultracar.treinamento.entidades.Cidade;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

	@Query("Select b From Bairro b Where b.nome = :nome")
	public Bairro findByNome(String nome);
	
	@Query("Select b From Bairro b Where b.cidade = ?1")
	public List<Bairro> findByCidade(Cidade cidade);
	
}