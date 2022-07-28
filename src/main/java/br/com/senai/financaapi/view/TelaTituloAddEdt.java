package br.com.senai.financaapi.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.stereotype.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;

@Component
public class TelaTituloAddEdt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField valorEdt;
	private JTextField venctoEdt;
	private JTextField bancoEdt;
	private JTextField fornecedorEdt;
	private JTextField descricaoEdt;

	public void mostrar() {
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public TelaTituloAddEdt() {
		setTitle("Título (INSERÇÃO/EDIÇÃO) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton consultarBtn = new JButton("Consultar");

		JButton salvarBtn = new JButton("Salvar");

		JLabel valorLbl = new JLabel("Valor (R$)");

		valorEdt = new JTextField();
		valorEdt.setColumns(10);

		JLabel venctoLbl = new JLabel("Vencto");

		venctoEdt = new JTextField();
		venctoEdt.setColumns(10);

		JLabel bancoLbl = new JLabel("Banco");

		bancoEdt = new JTextField();
		bancoEdt.setColumns(10);

		JLabel fornecedorLbl = new JLabel("Fornecedor");

		fornecedorEdt = new JTextField();
		fornecedorEdt.setColumns(10);

		JLabel descricaoLbl = new JLabel("Descrição dos Produtos e/ou Serviços");

		descricaoEdt = new JTextField();
		descricaoEdt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(descricaoEdt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(valorEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(valorLbl))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(venctoLbl)
										.addComponent(venctoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(bancoLbl)
												.addGap(61).addComponent(consultarBtn, GroupLayout.DEFAULT_SIZE, 101,
														Short.MAX_VALUE))
										.addComponent(bancoEdt, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
						.addComponent(fornecedorEdt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
						.addComponent(descricaoLbl).addComponent(fornecedorLbl).addComponent(salvarBtn,
								Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(31)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(valorLbl)
								.addComponent(bancoLbl).addComponent(venctoLbl))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(valorEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(venctoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(bancoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(consultarBtn)))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(fornecedorLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(fornecedorEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(descricaoLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(descricaoEdt, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(salvarBtn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE).addGap(6)));
		contentPane.setLayout(gl_contentPane);
	}
}
