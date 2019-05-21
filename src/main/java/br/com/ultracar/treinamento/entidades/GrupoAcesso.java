package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_grupoAcesso")
public class GrupoAcesso implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupoAcesso_sequence")
	@SequenceGenerator(name = "permissao_sequence", sequenceName = "grupoAcesso_id_sequence", allocationSize = 1)
	@Column(name = "id_grupoAcesso", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max =45)
	@Column(name = "tp_descricao", nullable = false)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
