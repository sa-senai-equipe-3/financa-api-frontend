package br.com.senai.financaapi.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.stereotype.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

@Component
public class TelaFornecedorEdt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField razaoEdt;
	private JTextField nomeFantasiaEdt;
	private JTextField loginEdt;
	private JTextField senhaEdt;
	private JTextField cnpjEdt;

	public void mostrar() {
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public TelaFornecedorEdt() {
		setTitle("Fornecedor (EDIÇÃO) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel razaoLbl = new JLabel("Razão Social");

		razaoEdt = new JTextField();
		razaoEdt.setColumns(10);

		JLabel nomeFantasiaLbl = new JLabel("Nome Fantasia");

		nomeFantasiaEdt = new JTextField();
		nomeFantasiaEdt.setColumns(10);

		JLabel cnpjLbl = new JLabel("CNPJ");

		JLabel loginLbl = new JLabel("Login");

		JLabel senhaLbl = new JLabel("Senha");

		JButton salvarBtn = new JButton("Salvar");

		loginEdt = new JTextField();
		loginEdt.setColumns(10);

		senhaEdt = new JTextField();
		senhaEdt.setColumns(10);

		cnpjEdt = new JTextField();
		cnpjEdt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(senhaEdt, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(razaoLbl).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(razaoEdt, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(nomeFantasiaLbl).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(nomeFantasiaEdt, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(cnpjLbl).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(cnpjEdt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(loginLbl).addGap(197)
						.addComponent(senhaLbl).addGap(181))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(316, Short.MAX_VALUE)
						.addComponent(salvarBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(razaoLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(razaoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(nomeFantasiaLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(nomeFantasiaEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(cnpjLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(cnpjEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(loginLbl).addComponent(senhaLbl))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(senhaEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(salvarBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(60)));
		contentPane.setLayout(gl_contentPane);
	}
}
