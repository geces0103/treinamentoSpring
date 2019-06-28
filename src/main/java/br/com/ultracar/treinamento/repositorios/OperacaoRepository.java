package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Operacao;
import br.com.ultracar.treinamento.entidades.Usuario;
import br.com.ultracar.treinamento.enumeradores.Crud;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

	@Query("Select op From Operacao op Where op.tipoOperacao = :tipoOperacao")
	public List<Operacao> findByTipo(Crud tipoOperacao);
	
	@Query("Select op From Operacao op Where op.descricao = :descricao")
	public List<Operacao> findByDescricao(String descricao);
	
	@Query("Select op From Operacao op "
		 + "Inner Join op.permissoesAcesso pa "
		 + "Inner Join pa.usuario u "
		 + "Where u = :usuario")
	public List<Operacao> findByUsuario(Usuario usuario);
	
}