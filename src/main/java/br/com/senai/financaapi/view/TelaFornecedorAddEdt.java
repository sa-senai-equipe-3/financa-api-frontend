package br.com.senai.financaapi.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;

import br.com.senai.financaapi.client.FornecedorClient;
import br.com.senai.financaapi.dto.Fornecedor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@Component
public class TelaFornecedorAddEdt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField razaoEdt;
	private JTextField nomeFantasiaEdt;
	private JTextField loginEdt;
	private JTextField senhaEdt;
	private JFormattedTextField cnpjEdt;
	private Fornecedor fornecedorParaEdicao;

	@Autowired
	@Lazy
	private TelaFornecedorListagem telaListagem;

	@Autowired
	@Lazy
	private TelaPrincipal telaPrincipal;

	@Autowired
	private FornecedorClient fornecedorClient;

	public TelaFornecedorAddEdt() throws ParseException {
		setTitle("Fornecedor (INSERÇÃO/EDIÇÃO) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 442);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel razaoLbl = new JLabel("Razão Social");
		razaoLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		razaoEdt = new JTextField();
		razaoEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		razaoEdt.setColumns(10);

		nomeFantasiaEdt = new JTextField();
		nomeFantasiaEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		nomeFantasiaEdt.setColumns(10);

		JLabel cnpjLbl = new JLabel("CNPJ");
		cnpjLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		JLabel loginLbl = new JLabel("Login");
		loginLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		JButton salvarBtn = new JButton("Salvar");
		salvarBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		salvarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (fornecedorParaEdicao != null) {
						fornecedorParaEdicao.setRazaoSocial(razaoEdt.getText());
						fornecedorParaEdicao.setNomeFantasia(nomeFantasiaEdt.getText());
						fornecedorParaEdicao.setCnpj(cnpjEdt.getText());
						fornecedorParaEdicao.setLogin(loginEdt.getText());
						fornecedorParaEdicao.setSenha(senhaEdt.getText());
						fornecedorClient.alterar(fornecedorParaEdicao);
					} else {
						Fornecedor fornecedorNovo = new Fornecedor();
						fornecedorNovo.setRazaoSocial(razaoEdt.getText());
						fornecedorNovo.setNomeFantasia(nomeFantasiaEdt.getText());
						fornecedorNovo.setCnpj(cnpjEdt.getText());
						fornecedorNovo.setLogin(loginEdt.getText());
						fornecedorNovo.setSenha(senhaEdt.getText());
						fornecedorClient.inserir(fornecedorNovo);
					}
				} catch (RestClientResponseException ex) {
					JOptionPane.showMessageDialog(contentPane, formatException(ex.getResponseBodyAsString()));
				}
			}
		});

		JButton consultarBtn = new JButton("Consultar");
		consultarBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		consultarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaListagem.setVisible(true);
			}
		});

		loginEdt = new JTextField();
		loginEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		loginEdt.setColumns(10);

		senhaEdt = new JTextField();
		senhaEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		senhaEdt.setColumns(10);

		cnpjEdt = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		cnpjEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		cnpjEdt.setColumns(10);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				telaPrincipal.setVisible(true);
			}
		});

		JLabel senhaLbl = new JLabel("Senha");
		senhaLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		JLabel nomeFantasiaLbl = new JLabel("Nome Fantasia");
		nomeFantasiaLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(razaoEdt, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
								.addComponent(nomeFantasiaEdt, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, 207,
												GroupLayout.PREFERRED_SIZE)
										.addGap(21).addComponent(senhaEdt, GroupLayout.PREFERRED_SIZE, 245,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(loginLbl)
										.addPreferredGap(ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
										.addComponent(senhaLbl))
								.addComponent(consultarBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 107,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(salvarBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 107,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(razaoLbl).addComponent(nomeFantasiaLbl).addComponent(cnpjLbl)
								.addComponent(cnpjEdt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(consultarBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addComponent(razaoLbl).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(razaoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(12).addComponent(nomeFantasiaLbl).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(nomeFantasiaEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(cnpjLbl)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(cnpjEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(loginLbl).addComponent(senhaLbl))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(senhaEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(38)
								.addComponent(salvarBtn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(70)));
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { loginEdt, senhaEdt, cnpjEdt });
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { salvarBtn, consultarBtn });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL,
				new java.awt.Component[] { loginEdt, senhaEdt, cnpjEdt, senhaLbl });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { salvarBtn, consultarBtn });
		contentPane.setLayout(gl_contentPane);
	}

	public void inicializar(Fornecedor fornecedorInitEdicao) {
		if (fornecedorInitEdicao != null) {
			razaoEdt.setText(fornecedorInitEdicao.getRazaoSocial());
			nomeFantasiaEdt.setText(fornecedorInitEdicao.getNomeFantasia());
			cnpjEdt.setText(fornecedorInitEdicao.getCnpj());
			loginEdt.setText(fornecedorInitEdicao.getLogin());
			senhaEdt.setText(fornecedorInitEdicao.getSenha());
			fornecedorParaEdicao = fornecedorInitEdicao;
		}
	}
	
	public String formatException(String excpetion) {
		String[] exceptionFields = excpetion.split("\"");
		
		return exceptionFields[7];
	}
}
