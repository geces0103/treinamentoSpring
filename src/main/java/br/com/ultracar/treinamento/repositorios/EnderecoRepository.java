package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Endereco;
import br.com.ultracar.treinamento.enumeradores.Crud;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

//	@Async
//	@Query("Select s From Servico s " + "Inner Join s.operacao o " + "o.tipoOperacao = :tipoOperacao")
//	public List<Endereco> findByTipoOperacao(Crud tipoOperacao);
}