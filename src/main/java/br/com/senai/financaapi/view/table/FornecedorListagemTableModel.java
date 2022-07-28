package br.com.senai.financaapi.view.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.senai.financaapi.entity.Fornecedor;

public class FornecedorListagemTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int QTDE_COLUNAS = 2;
	private List<Fornecedor> fornecedores;

	// Construtor
	public FornecedorListagemTableModel(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	// Contagem das linhas da tabela
	@Override
	public int getRowCount() {
		return fornecedores.size();
	}

	// Contagem das colunas da tabela
	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}

	// Alias para as colunas
	public String getColumnName(int column) {

		if (column == 0) {
			return "ID";
		}

		else if (column == 1) {
			return "Nome Fantasia";
		}

		throw new IllegalArgumentException("Indice inválido");
	}

	// Obter ID ou Nome Fantasia de uma linha
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (columnIndex == 0) {
			return this.fornecedores.get(rowIndex).getId();
		}

		else if (columnIndex == 1) {
			return this.fornecedores.get(rowIndex).getNomeFantasia();
		}

		throw new IllegalArgumentException("Índice inválido");
	}

}
