package br.com.senai.financaapi.view;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.senai.financaapi.controller.TituloController;
import br.com.senai.financaapi.entity.Titulo;
import br.com.senai.financaapi.view.table.TituloListagemTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class TelaTituloListagem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filtroEdt;
	private TableColumnModel cm;

	@Autowired
	private TituloController tituloController;

	private void updTituloListagemTableModel(JTable tabela) {
		List<Titulo> titulos = tituloController.listarPor(filtroEdt.getText());
		TituloListagemTableModel modelo = new TituloListagemTableModel(titulos);
		tabela.setModel(modelo);
		cm = tabela.getColumnModel();
		cm.getColumn(0).setPreferredWidth(50);
		cm.getColumn(1).setPreferredWidth(352);
		tabela.updateUI();
	}

	public void mostrar() {
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public TelaTituloListagem() {
		setTitle("Título (LISTAGEM) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTable tabela = new JTable();
		tabela.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(tabela);

		JButton adicionarBtn = new JButton("Adicionar");

		JLabel filtroLbl = new JLabel("Filtro");

		filtroEdt = new JTextField();
		filtroEdt.setColumns(10);

		JButton listarBtn = new JButton("Listar");
		listarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updTituloListagemTableModel(tabela);
			}
		});

		JButton removerBtn = new JButton("Remover");

		JButton editarBtn = new JButton("Editar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(filtroLbl).addContainerGap(350,
						Short.MAX_VALUE))
				.addComponent(filtroEdt, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(adicionarBtn))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(listarBtn,
						GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(223)
						.addComponent(editarBtn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(removerBtn)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(adicionarBtn)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(filtroLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(filtroEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(listarBtn).addGap(18)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(removerBtn).addComponent(editarBtn))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
