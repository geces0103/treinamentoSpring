package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface CustomizedUsuarioRepository {

	public Page<Usuario> findByFilter(Usuario user, Pageable pageble);
}
