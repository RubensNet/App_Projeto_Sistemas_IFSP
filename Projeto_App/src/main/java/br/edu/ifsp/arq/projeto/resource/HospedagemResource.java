package br.edu.ifsp.arq.projeto.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.projeto.domain.model.Hospedagem;
import br.edu.ifsp.arq.projeto.repository.HospedagemRepository;
import br.edu.ifsp.arq.projeto.service.HospedagemService;

@RestController
@RequestMapping("/hospedagens")
public class HospedagemResource {
	
	@Autowired
	private HospedagemRepository hospedagemRepository;
	
	@Autowired
	private HospedagemService hospedagemService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_HOSPEDAGEM') and #oauth2.hasScope('read')")
	public List<Hospedagem> listar(){
		return hospedagemRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_HOSPEDAGEM') and #oauth2.hasScope('write')")
	public Hospedagem criar(@Valid @RequestBody Hospedagem hospedagem, HttpServletResponse response) {
		return hospedagemRepository.save(hospedagem);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_HOSPEDAGEM') and #oauth2.hasScope('read')")
	public ResponseEntity<Hospedagem> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Hospedagem> hospedagem = hospedagemRepository.findById(codigo);
		if(hospedagem.isPresent()) {
			return ResponseEntity.ok(hospedagem.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_HOSPEDAGEM') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		hospedagemRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_HOSPEDAGEM') and #oauth2.hasScope('write')")
	public ResponseEntity<Hospedagem> atualizar(@PathVariable Long codigo, @Valid @RequestBody Hospedagem hospedagem){
		Hospedagem hospedagemSalvo = hospedagemService.atualizar(codigo, hospedagem);
		return ResponseEntity.ok(hospedagemSalvo);
	}
	
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_HOSPEDAGEM') and #oauth2.hasScope('write')")
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo){
		hospedagemService.atualizarPropriedadeAtivo(codigo, ativo);
	}
}