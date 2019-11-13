package br.com.ultracar.treinamento.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "tb_cep")
public class Cep {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cep_sequence")
	@SequenceGenerator(name = "cep_sequence", sequenceName = "cep_id_sequence", allocationSize = 1)
	@Column(name = "id_cep", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = "nr_numero", length = 8, nullable = false)
	private Integer numeroCep;
	
	@JoinTable(name = "TB_CEP_ENDERECO", joinColumns = { 
			@JoinColumn(name = "ID_CEP", foreignKey = @ForeignKey(name = "fk_cep_endereco")) }, inverseJoinColumns = { 
			@JoinColumn(name = "ID_ENDERECO", foreignKey = @ForeignKey(name = "fk_endereco_cep")) })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Endereco> enderecos = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroCep() {
		return numeroCep;
	}

	public void setNumeroCep(Integer numeroCep) {
		this.numeroCep = numeroCep;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
