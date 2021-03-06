package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Cidade;
import br.com.ultracar.treinamento.entidades.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query("Select c From Cidade c Where c.nome Like %?1%")
	public List<Cidade> findByNome(String nome);
	
	@Query("Select c From Cidade c Where c.estado = :estado")
	public List<Cidade> findByEstado(Estado estado);
	
}