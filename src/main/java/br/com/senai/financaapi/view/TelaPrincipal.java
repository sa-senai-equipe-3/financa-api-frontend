package br.com.senai.financaapi.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.senai.financaapi.dto.Usuario;
import br.com.senai.financaapi.enums.Perfil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@Component
public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuarioEdt;
	private JButton titulosBtn;
	private JButton sairBtn;
	private JLabel usuarioLbl;

	@Autowired
	@Lazy
	TelaFornecedorListagem telaFornecedor;

	@Autowired
	@Lazy
	TelaTituloListagem telaTitulo;

	@Autowired
	TelaLogin telaLogin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		setTitle("Principal - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 404);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		usuarioLbl = new JLabel("Usuário Logado");
		usuarioLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 17));

		usuarioEdt = new JTextField();
		usuarioEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		usuarioEdt.setEditable(false);
		usuarioEdt.setColumns(10);

		titulosBtn = new JButton("Títulos");
		titulosBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		titulosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaTitulo.setVisible(true);
			}
		});

		JButton fornecedoresBtn = new JButton("Fornecedores");
		fornecedoresBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		fornecedoresBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaFornecedor.setVisible(true);
			}
		});

		sairBtn = new JButton("Sair");
		sairBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		sairBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaLogin.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(usuarioLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(usuarioEdt, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(sairBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(titulosBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(fornecedoresBtn))
							.addGap(179))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addComponent(fornecedoresBtn)
					.addGap(18)
					.addComponent(titulosBtn)
					.addGap(18)
					.addComponent(sairBtn)
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usuarioLbl)
						.addComponent(usuarioEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void inicializar(Usuario usuarioLogado) {
		if (usuarioLogado.getPerfil() == Perfil.FORNECEDOR) {
			titulosBtn.setVisible(false);
		} else {
			titulosBtn.setVisible(true);
		}
		usuarioEdt.setText(usuarioLogado.getNomeCompleto());
	}
}
