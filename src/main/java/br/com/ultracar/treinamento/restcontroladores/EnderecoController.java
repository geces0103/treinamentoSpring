package br.com.ultracar.treinamento.restcontroladores;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultracar.treinamento.entidades.Endereco;
import br.com.ultracar.treinamento.repositorios.EnderecoRepository;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecos; 
	
	@PostMapping
	public Endereco adicionar(@Valid @RequestBody Endereco endereco ) {
		return enderecos.save(endereco);
		
	}
	
	@GetMapping
	public List<Endereco> listar() {
		return enderecos.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> buscar(@PathVariable Long id) {
		Endereco contato = enderecos.getOne(id);
		
		if (Objects.isNull(contato)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(contato);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Endereco contato) {
		Endereco existente = enderecos.getOne(id);
		
		if (Objects.isNull(existente)) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(contato, existente, "id");
		
		existente = enderecos.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Endereco contato = enderecos.getOne(id);
		
		if (Objects.isNull(contato)) {
			return ResponseEntity.notFound().build();
		}
		
		enderecos.delete(contato);
		
		return ResponseEntity.noContent().build();
	}

}
