package br.com.senai.financaapi.view.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.senai.financaapi.entity.Titulo;

public class TituloListagemTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int QTDE_COLUNAS = 3;
	private List<Titulo> titulos;

	public TituloListagemTableModel(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	@Override
	public int getRowCount() {
		return titulos.size();
	}

	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}

	public String getColumnName(int column) {

		if (column == 0) {
			return "ID";
		}

		else if (column == 1) {
			return "Valor";
		}

		else if (column == 2) {
			return "Fornecedor";
		}

		throw new IllegalArgumentException("Indice inválido");
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (columnIndex == 0) {
			return this.titulos.get(rowIndex).getId();
		}

		else if (columnIndex == 1) {
			return this.titulos.get(rowIndex).getValor();
		}

		else if (columnIndex == 2) {
			return this.titulos.get(rowIndex).getFornecedor();
		}

		throw new IllegalArgumentException("Índice inválido");
	}

}
