CREATE TABLE servico(
	codigo_servico BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_animal  BIGINT(20),   -- nome animal (pelo o código do animal, também retornará o cliente a qual esse animal pertence)
	codigo_prestador BIGINT(20), -- nome_prestador 
	codigo_hospedagem BIGINT(20),   -- nome serviço
	dt_ini DATE,
	dt_fim DATE,	
	FOREIGN KEY (codigo_animal) REFERENCES animal(codigo_animal),
	FOREIGN KEY (codigo_prestador) REFERENCES prestador(codigo_prestador),
	FOREIGN KEY (codigo_hospedagem) REFERENCES hospedagem(codigo_hospedagem),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;