package br.edu.ifsp.arq.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.projeto.domain.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
