package br.com.senai.financaapi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import br.com.senai.financaapi.entity.Fornecedor;
import br.com.senai.financaapi.entity.Titulo;

@Controller
public class TituloController {

	public void inserir(Titulo titulo) {
	}

	public void remover(int id) {
	}

	public void alterar(Titulo titulo) {
	}

	/*
	 * public void listarPor(int id) { }
	 */

	public List<Titulo> listarPor(String descricao) {

		Fornecedor fornecedorFalso = new Fornecedor();
		fornecedorFalso.setId(1);
		fornecedorFalso.setNomeFantasia("Fornecedor Falso");

		LocalDate dataVencimento = LocalDate.of(2022, 07, 15);

		Titulo tituloFalso = new Titulo();
		tituloFalso.setId(1);
		tituloFalso.setDescricao("Fornecedor Falso");
		tituloFalso.setFornecedor(fornecedorFalso);
		tituloFalso.setValor(new BigDecimal(String.valueOf("500")));
		tituloFalso.setNomeBanco("tituloFalso");
		tituloFalso.setDataVencimento(dataVencimento);

		List<Titulo> titulos = new ArrayList<Titulo>();
		titulos.add(tituloFalso);

		return titulos;
	}
}
