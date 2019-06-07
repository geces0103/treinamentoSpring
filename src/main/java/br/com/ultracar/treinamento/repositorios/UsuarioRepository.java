package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Operacao;
import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


	@Query( 	"Select operacoes From Usuario usuario "
			+	"Inner Join ususario.permissoesAcesso permissoesAcesso "
			+	"Inner Join permissoesAcesso.operacoes operacoes "
			+	"Where usuario = :usuario ")
	public List<Operacao> findOperacaoByUsuatio(Usuario usuario);





}
