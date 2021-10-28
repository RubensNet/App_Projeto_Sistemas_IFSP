package br.edu.ifsp.arq.projeto.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.projeto.domain.model.Servico;
import br.edu.ifsp.arq.projeto.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;

	public Servico atualizar(Long codigo, Servico servico) {
		Servico servicoSalva = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(servico, servicoSalva, "codigo");
		return servicoRepository.save(servicoSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Servico servicoSalva = buscarPessoaPeloCodigo(codigo);
		servicoSalva.setAtivo(ativo);
		servicoRepository.save(servicoSalva);
	}
	
	private Servico buscarPessoaPeloCodigo(Long codigo) {
		Servico servicoSalva = servicoRepository.findById(codigo)
			   .orElseThrow(()-> new EmptyResultDataAccessException(1));
		return servicoSalva;
	}

}
