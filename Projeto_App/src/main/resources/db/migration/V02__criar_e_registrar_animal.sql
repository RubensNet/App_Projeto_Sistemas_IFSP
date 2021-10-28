CREATE TABLE animal(
	codigo_animal BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_cliente BIGINT(20) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	tipo VARCHAR(10) NOT NULL,
	idade VARCHAR(5),
	sexo VARCHAR(10),
	castrado VARCHAR(5),
	raca VARCHAR(20),		
	ativo BOOLEAN NOT NULL,
	FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo_cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;