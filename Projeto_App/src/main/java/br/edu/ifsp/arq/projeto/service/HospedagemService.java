package br.edu.ifsp.arq.projeto.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.projeto.domain.model.Hospedagem;
import br.edu.ifsp.arq.projeto.repository.HospedagemRepository;

@Service
public class HospedagemService {
	
	@Autowired
	private HospedagemRepository hospedagemRepository;

	public Hospedagem atualizar(Long codigo, Hospedagem hospedagem) {
		Hospedagem hospedagemSalva = buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(hospedagem, hospedagemSalva, "codigo");
		return hospedagemRepository.save(hospedagemSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Hospedagem hospedagemSalva = buscarPessoaPeloCodigo(codigo);
		hospedagemSalva.setAtivo(ativo);
		hospedagemRepository.save(hospedagemSalva);
	}
	
	private Hospedagem buscarPessoaPeloCodigo(Long codigo) {
		Hospedagem hospedagemSalva = hospedagemRepository.findById(codigo)
				.orElseThrow(()-> new EmptyResultDataAccessException(1));
		return hospedagemSalva;
	}

}
