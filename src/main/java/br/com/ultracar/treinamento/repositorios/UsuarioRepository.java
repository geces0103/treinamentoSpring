package br.com.ultracar.treinamento.repositorios;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Operacao;
import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> , CustomizedUsuarioRepository{


	@Nullable
	@Query("Select u From Usuario u Where u.login = :login")
	public Usuario findByLogin(String login);


}
