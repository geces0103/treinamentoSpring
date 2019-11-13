package br.com.ultracar.treinamento.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_numero")
public class Numero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "numero_sequence")
	@SequenceGenerator(name = "numero_sequence", sequenceName = "numero_id_sequence", allocationSize = 1)
	@Column(name = "id_numero", nullable = false)
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "numero")
	private Set<Endereco> enderecos = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
