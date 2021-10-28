CREATE TABLE prestador (
	codigo_prestador BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	telefone_celular VARCHAR(20) NOT NULL,
	telefone_fixo VARCHAR(20),
	email VARCHAR(30),
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	tipo_servico VARCHAR(10) NOT NULL,
	tipo_ambiente VARCHAR(10) NOT NULL,
	tipo_animal VARCHAR(10) NOT NULL,
	quantidade_animal VARCHAR(10) NOT NULL,
	certificado_num VARCHAR(20) NOT NULL,
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;