package br.edu.ifsp.arq.projeto.domain.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "prestador")
public class Prestador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@NotNull
	@Size(min = 3, max = 50)
	private String nome;
	@NotNull	
	@CPF
	private String cpf;
	@NotNull
	private String telefone_celular;
	private String telefone_fixo;
	@NotNull
	@Email
	private String email;	
	@Embedded
	private Endereco endereco;		
	@NotNull	
	private String tipo_servico;
	@NotNull	
	private String tipo_ambiente;
	@NotNull	
	private String tipo_animal;
	@NotNull	
	private String quantidade_animal;
	@NotNull	
	private String certificado_num;
	@NotNull
	private Boolean ativo;		
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone_celular() {
		return telefone_celular;
	}
	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}
	public String getTelefone_fixo() {
		return telefone_fixo;
	}
	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTipo_servico() {
		return tipo_servico;
	}
	public void setTipo_servico(String tipo_servico) {
		this.tipo_servico = tipo_servico;
	}
	public String getTipo_ambiente() {
		return tipo_ambiente;
	}
	public void setTipo_ambiente(String tipo_ambiente) {
		this.tipo_ambiente = tipo_ambiente;
	}
	public String getTipo_animal() {
		return tipo_animal;
	}
	public void setTipo_animal(String tipo_animal) {
		this.tipo_animal = tipo_animal;
	}
	public String getQuantidade_animal() {
		return quantidade_animal;
	}
	public void setQuantidade_animal(String quantidade_animal) {
		this.quantidade_animal = quantidade_animal;
	}
	public String getCertificado_num() {
		return certificado_num;
	}
	public void setCertificado_num(String certificado_num) {
		this.certificado_num = certificado_num;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestador other = (Prestador) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}