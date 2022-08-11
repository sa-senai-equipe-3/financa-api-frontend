package br.com.senai.financaapi.view;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.financaapi.client.TituloClient;
import br.com.senai.financaapi.dto.Titulo;
import br.com.senai.financaapi.view.table.TituloListagemTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@Component
public class TelaTituloListagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filtroEdt;
	private TableColumnModel cm;
	private JTable tabela;
	private List<Titulo> listaTitulos;

	@Autowired
	private TituloClient tituloClient;

	@Autowired
	private TelaTituloAddEdt telaTituloAdd;

	@Autowired
	private TelaPrincipal telaPrincipal;

	public void mostrar() {
		this.setVisible(true);
	}

	public TelaTituloListagem() {
		setTitle("Título (LISTAGEM) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 505);
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
				telaTituloAdd.inicializar(null);
				telaTituloAdd.clear();
				telaTituloAdd.setVisible(true);
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
				if (tabela.getSelectedRow() != -1 && listaTitulos != null) {
					int opcaoSelecionada = JOptionPane.showConfirmDialog(contentPane, "Deseja realmente remover?!",
							"Remoção", JOptionPane.YES_NO_OPTION);

					if (opcaoSelecionada == JOptionPane.YES_OPTION) {
						Titulo tituloSelecionado = listaTitulos.get(tabela.getSelectedRow());
						tituloClient.excluir(tituloSelecionado);
						updTituloListagemTableModel(tabela);
						JOptionPane.showMessageDialog(null, "Titulo removido com sucesso!");
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
				if (tabela.getSelectedRow() != -1 && listaTitulos != null) {
					Titulo tituloSelecionado = listaTitulos.get(tabela.getSelectedRow());
					telaTituloAdd.inicializar(tituloSelecionado);
					setVisible(false);
					telaTituloAdd.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um registro na tabela para edição");
				}
			}
		});

		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!filtroEdt.getText().isBlank()) {
					updTituloListagemTableModel(tabela);
				} else {
					JOptionPane.showMessageDialog(null, "O filtro e' obrigatorio");
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
										.addComponent(filtroEdt, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addContainerGap().addComponent(
												scrollPane, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addContainerGap(338, Short.MAX_VALUE)
												.addComponent(editarBtn, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(removerBtn))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(454, Short.MAX_VALUE)
										.addComponent(adicionarBtn))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(454, Short.MAX_VALUE)
										.addComponent(btnListar)))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(filtroLbl)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(adicionarBtn).addGap(10)
						.addComponent(filtroLbl).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(filtroEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(31).addComponent(btnListar).addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
						.addGap(26).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(removerBtn).addComponent(editarBtn))
						.addContainerGap()));
		gl_contentPane.linkSize(SwingConstants.VERTICAL,
				new java.awt.Component[] { adicionarBtn, removerBtn, editarBtn, btnListar });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL,
				new java.awt.Component[] { adicionarBtn, removerBtn, editarBtn, btnListar });
		contentPane.setLayout(gl_contentPane);

	}

	public void setDefaultCloseOperation() {
		setVisible(false);
		telaPrincipal.setVisible(true);
	}

	private void updTituloListagemTableModel(JTable tabela) {
		listaTitulos = tituloClient.listarPor(filtroEdt.getText());
		TituloListagemTableModel modelo = new TituloListagemTableModel(listaTitulos);
		tabela.setModel(modelo);
		cm = tabela.getColumnModel();
		cm.getColumn(0).setPreferredWidth(50);
		cm.getColumn(1).setPreferredWidth(352);
		tabela.updateUI();
	}
}
