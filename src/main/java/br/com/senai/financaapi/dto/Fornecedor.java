package br.com.senai.financaapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fornecedor {
	
	@EqualsAndHashCode.Include
	private Integer id;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private String cnpj;
	
	private String login;
	
	private String senha;
	
	@Override
	public String toString() {
		return this.id + " - " + this.nomeFantasia;
	}
	
}
