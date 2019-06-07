package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.ultracar.treinamento.enumeradores.Situacao;
@SuppressWarnings("serial")
@Entity
@Table(name = "tb_permissao_acesso")
public class PermissaoAcesso implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_sequence")
	@SequenceGenerator(name = "permissao_sequence", sequenceName = "permissao_id_sequence", allocationSize = 1)
	@Column(name = "id_permissao", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_situacao", nullable = false)
	private Situacao situacao;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grupoAcesso", nullable = false)
	private GrupoAcesso grupoAcesso ;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tb_permissao_acesso_operacao",
		joinColumns = {@JoinColumn(name= "id_operacao")},
		inverseJoinColumns = {@JoinColumn(name = "id_permissao_acesso")})
	private Set<Operacao> operacoes = new HashSet<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public GrupoAcesso getGrupoAcesso() {
		return grupoAcesso;
	}

	public void setGrupoAcesso(GrupoAcesso grupoAcesso) {
		this.grupoAcesso = grupoAcesso;
	}
	
}
