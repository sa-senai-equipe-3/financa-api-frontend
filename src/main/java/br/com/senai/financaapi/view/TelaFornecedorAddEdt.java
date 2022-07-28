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
public class TelaFornecedorAddEdt extends JFrame {

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

	/**
	 * Create the frame.
	 */
	public TelaFornecedorAddEdt() {
		setTitle("Fornecedor (INSERÇÃO/EDIÇÃO) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
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

		JButton consultarBtn = new JButton("Consultar");

		loginEdt = new JTextField();
		loginEdt.setColumns(10);

		senhaEdt = new JTextField();
		senhaEdt.setColumns(10);

		cnpjEdt = new JTextField();
		cnpjEdt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(loginLbl)
				.addPreferredGap(ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(consultarBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(senhaLbl).addGap(176)))
						.addComponent(salvarBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 107,
								GroupLayout.PREFERRED_SIZE)))
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addComponent(nomeFantasiaLbl).addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(senhaEdt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE).addGap(4))
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addComponent(razaoLbl).addContainerGap())
				.addComponent(razaoEdt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(nomeFantasiaEdt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addComponent(cnpjLbl).addContainerGap())
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup()
								.addComponent(cnpjEdt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(consultarBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE).addGap(4)
				.addComponent(razaoLbl).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(razaoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(nomeFantasiaLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(nomeFantasiaEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(cnpjLbl).addGap(1)
				.addComponent(cnpjEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(senhaLbl).addComponent(loginLbl))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(senhaEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(34).addComponent(salvarBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
