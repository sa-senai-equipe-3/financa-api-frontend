package br.com.senai.financaapi.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity(name = "Fornecedor")
@Table(name = "fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "razao_social")
	@NotEmpty(message = "A razão social do fornecedor não pode estar vazia")
	@Size(max = 80, message = "A razão social do fornecedor não deve conter mais que 80 caracteres")
	private String razaoSocial;

	@Column(name = "nome_fantasia")
	@NotEmpty(message = "O nome fantasia do fornecedor não pode estar vazio")
	@Size(max = 90, message = "O nome fantasia do fornecedor não deve conter mais que 90 caracteres")
	private String nomeFantasia;

	@Column(name = "cnpj")
	@NotEmpty(message = "O CNPJ do fornecedor não pode ser vazio")
	@Size(max = 18, message = "O CNPJ do fornecedor não deve possuir mais que 18 caracteres")
	private String cnpj;

	@Column(name = "login")
	@NotEmpty(message = "O login do fornecedor não pode ser vazio")
	@Size(max = 20, message = "O login do fornecedor não deve possuir mais que 20 caracteres")
	private String login;

	@Column(name = "senha")
	@NotEmpty(message = "A senha do fornecedor não pode ser vazia")
	@Size(max = 10, message = "A senha do fornecedor não deve possuitr mais que 10 caracteres")
	private String senha;

}