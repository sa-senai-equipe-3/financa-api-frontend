package br.com.senai.financaapi.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import br.com.senai.financaapi.entity.Fornecedor;

@Controller
public class FornecedorController {

	public void inserir(Fornecedor fornecedor) {
	}

	public void remover(int id) {
	}

	public void alterar(Fornecedor fornecedor) {
	}

	/*
	 * public void listarPor(int id) { }
	 */

	public List<Fornecedor> listarPor(String nomeFantasia) {

		Fornecedor fornecedorFalso = new Fornecedor();
		fornecedorFalso.setId(1);
		fornecedorFalso.setNomeFantasia("Fornecedor Falso");

		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		fornecedores.add(fornecedorFalso);

		return fornecedores;
	}
}
