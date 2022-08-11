package br.com.senai.financaapi.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import br.com.senai.financaapi.client.UsuarioClient;
import br.com.senai.financaapi.dto.Usuario;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

@Component
public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginEdt;
	private JPasswordField senhaEdt;
	private JButton logarBtn;

	@Autowired
	private UsuarioClient usuarioClient;

	@Autowired
	@Lazy
	private TelaPrincipal telaPrincipal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setTitle("Login - SA System 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 474);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel loginLbl = new JLabel("Login");
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
		loginLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 20));

		loginEdt = new JTextField();
		loginEdt.setHorizontalAlignment(SwingConstants.CENTER);
		loginEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		loginEdt.setColumns(10);

		JLabel senhaLbl = new JLabel("Senha");
		senhaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		senhaLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 20));

		senhaEdt = new JPasswordField();
		senhaEdt.setHorizontalAlignment(SwingConstants.CENTER);
		senhaEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		senhaEdt.setColumns(10);

		logarBtn = new JButton("Logar");
		logarBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		logarBtn.addActionListener(new ActionListener() {
			// TODO Resolução duvidosa para JPassWordFild
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				List<Usuario> usuariosBuscados = usuarioClient.listar();

				for (Usuario u : usuariosBuscados) {
					if (u.getLogin().equals(loginEdt.getText()) && u.getSenha().equals(senhaEdt.getText())) {
						setVisible(false);
						telaPrincipal.inicializar(u);
						telaPrincipal.setVisible(true);
						return;
					}
				}

				JOptionPane.showMessageDialog(null, "Login ou senha inválidos");
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(88, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(senhaEdt, 172, 172, 172)
									.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 53, GroupLayout.PREFERRED_SIZE)
									.addComponent(loginLbl)
									.addGap(52))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 55, GroupLayout.PREFERRED_SIZE)
									.addComponent(senhaLbl)
									.addGap(50)))
							.addGap(77))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(logarBtn, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(129))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(125, Short.MAX_VALUE)
					.addComponent(loginLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(senhaLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(senhaEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(logarBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(106))
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {loginLbl, senhaLbl, logarBtn});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {loginEdt, senhaEdt});
		contentPane.setLayout(gl_contentPane);
	}
}
