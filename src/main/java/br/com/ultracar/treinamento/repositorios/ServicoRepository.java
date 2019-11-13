package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Servico;
import br.com.ultracar.treinamento.enumeradores.Crud;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
//
//	@Async
//	@Query("Select s From Servico s "
//		 + "Inner Join s.operacao o "
//		 + "Where o.tipoOperacao = :tipoOperacao")
//	public List<Servico> findByTipoOperacao(Crud tipoOperacao);
//
//	@Modifying
//	@Query("Update Servico s Set s.solicitante.id = ?1 where s.solicitante.id = 2? ")
//	public Integer updateBySolicitante(Long idSolicitante, Long novoSolicitante);
	
}