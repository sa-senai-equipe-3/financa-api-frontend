package br.com.senai.financaapi.view;

import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.financaapi.client.FornecedorClient;
import br.com.senai.financaapi.dto.Fornecedor;
import br.com.senai.financaapi.view.table.FornecedorListagemTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@Component
public class TelaFornecedorListagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filtroEdt;
	private JTable tabela;
	private List<Fornecedor> listaFornecedores;
	private TableColumnModel cm;

	@Autowired
	TelaFornecedorAddEdt telaFornecedorAdd;

	@Autowired
	TelaPrincipal telaPrincipal;

	@Autowired
	FornecedorClient fornecedorClient;

	public TelaFornecedorListagem() {
		setTitle("Fornecedor (LISTAGEM) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 532);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tabela = new JTable();
		tabela.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		tabela.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(tabela);

		JButton adicionarBtn = new JButton("Adicionar");
		adicionarBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		adicionarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaFornecedorAdd.clear();
				telaFornecedorAdd.setVisible(true);
			}
		});

		JButton listarBtn = new JButton("Listar");
		listarBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		listarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!filtroEdt.getText().isBlank()) {
					updFornecedorListagemTableModel(tabela);
				} else {
					JOptionPane.showMessageDialog(null, "O filtro e' obrigatorio");
				}
			}
		});

		JLabel filtroLbl = new JLabel("Filtro");
		filtroLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		filtroEdt = new JTextField();
		filtroEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		filtroEdt.setColumns(10);

		JButton removerBtn = new JButton("Remover");
		removerBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		removerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabela.getSelectedRow() != -1 && listaFornecedores != null) {
					int opcaoSelecionada = JOptionPane.showConfirmDialog(contentPane, "Deseja realmente remover?!",
							"Remoção", JOptionPane.YES_NO_OPTION);

					if (opcaoSelecionada == JOptionPane.YES_OPTION) {
						Fornecedor fornecedoroSelecionado = listaFornecedores.get(tabela.getSelectedRow());
						fornecedorClient.excluir(fornecedoroSelecionado);
						updFornecedorListagemTableModel(tabela);
						JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um registro para remoção");
				}
			}
		});

		JButton editarBtn = new JButton("Editar");
		editarBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		editarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabela.getSelectedRow() != -1 && listaFornecedores != null) {
					Fornecedor fornecedoroSelecionado = listaFornecedores.get(tabela.getSelectedRow());
					telaFornecedorAdd.inicializar(fornecedoroSelecionado);
					setVisible(false);
					telaFornecedorAdd.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um registro na tabela para edição");
				}
			}
		});

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				telaPrincipal.setVisible(true);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addComponent(filtroEdt, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addContainerGap(314, Short.MAX_VALUE)
												.addComponent(editarBtn, GroupLayout.PREFERRED_SIZE, 105,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(removerBtn))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addContainerGap().addComponent(
												scrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(437, Short.MAX_VALUE)
										.addComponent(listarBtn, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(437, Short.MAX_VALUE)
										.addComponent(adicionarBtn)))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(filtroLbl,
								GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(adicionarBtn)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(filtroLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(filtroEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE).addComponent(listarBtn).addGap(18)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(removerBtn).addComponent(editarBtn))
				.addContainerGap()));
		gl_contentPane.linkSize(SwingConstants.VERTICAL,
				new java.awt.Component[] { adicionarBtn, listarBtn, removerBtn, editarBtn });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL,
				new java.awt.Component[] { adicionarBtn, listarBtn, removerBtn, editarBtn });
		contentPane.setLayout(gl_contentPane);
	}

	private void updFornecedorListagemTableModel(JTable tabela) {
		listaFornecedores = fornecedorClient.listarPor(filtroEdt.getText());
		FornecedorListagemTableModel modelo = new FornecedorListagemTableModel(listaFornecedores);
		tabela.setModel(modelo);
		cm = tabela.getColumnModel();
		cm.getColumn(0).setPreferredWidth(50);
		cm.getColumn(1).setPreferredWidth(352);
		tabela.updateUI();
	}
}
