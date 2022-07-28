package br.com.senai.financaapi.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginEdt;
	private JTextField senhaEdt;
	private JButton logarBtn;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setTitle("Login - SA System 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel loginLbl = new JLabel("Login");

		loginEdt = new JTextField();
		loginEdt.setColumns(10);

		JLabel senhaLbl = new JLabel("Senha");

		senhaEdt = new JTextField();
		senhaEdt.setColumns(10);

		logarBtn = new JButton("Logar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
														.createSequentialGroup().addContainerGap()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(
																		loginEdt, GroupLayout.DEFAULT_SIZE, 229,
																		Short.MAX_VALUE)
																.addComponent(
																		senhaEdt, GroupLayout.DEFAULT_SIZE, 229,
																		Short.MAX_VALUE)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addGroup(gl_contentPane
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(loginLbl)
																				.addComponent(senhaLbl))
																		.addGap(109))))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(71)
														.addComponent(logarBtn, GroupLayout.PREFERRED_SIZE, 104,
																GroupLayout.PREFERRED_SIZE)))
												.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(19).addComponent(loginLbl)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(loginEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(senhaLbl).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(senhaEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(28).addComponent(logarBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
