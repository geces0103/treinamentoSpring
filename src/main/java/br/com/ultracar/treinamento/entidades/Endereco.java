package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ultracar.treinamento.enumeradores.TipoLocal;

@Entity
@SuppressWarnings("serial")
@Table(name = "tb_endereco")
public class Endereco implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
	@SequenceGenerator(name = "endereco_sequence", sequenceName = "endereco_id_sequence", allocationSize = 1)
	@Column(name = "id_endereco", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 128)
	@Column(name = "ds_logradouro", length = 128, nullable = false)
	private String logradouro;
	
	@Column(name = "ds_complemento", length = 255)
	private String complemento;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_tipo_local", length = 10, nullable = false)
	private TipoLocal tipoLocal;

	@ManyToMany(mappedBy = "enderecos", fetch = FetchType.LAZY)
	private Set<Bairro> bairros = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "enderecos")
	private Set<Cep> ceps = new HashSet<>();
	
	@NotNull
	@JoinColumn(name = "ID_NUMERO", nullable = false, foreignKey = @ForeignKey(name = "fk_numero_endereco"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Numero numero;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public TipoLocal getTipoLocal() {
		return tipoLocal;
	}

	public void setTipoLocal(TipoLocal tipoLocal) {
		this.tipoLocal = tipoLocal;
	}

	public Set<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(Set<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Set<Cep> getCeps() {
		return ceps;
	}

	public void setCeps(Set<Cep> ceps) {
		this.ceps = ceps;
	}

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}
}	
