package br.com.senai.financaapi.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;

import br.com.senai.financaapi.client.FornecedorClient;
import br.com.senai.financaapi.client.TituloClient;
import br.com.senai.financaapi.dto.Fornecedor;
import br.com.senai.financaapi.dto.Titulo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@Component
public class TelaTituloAddEdt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField valorEdt;
	private JFormattedTextField venctoEdt;
	private JTextField bancoEdt;
	private JTextField descricaoEdt;
	private JComboBox<Fornecedor> fornecedorComboBox;
	private Titulo tituloParaEdicao;

	@Autowired
	@Lazy
	private TelaTituloListagem telaListagem;

	@Autowired
	@Lazy
	private TelaPrincipal telaPrincipal;

	@Autowired
	private FornecedorClient fornecedorClient;

	@Autowired
	private TituloClient tituloClient;

	public void mostrar() {
		this.setVisible(true);
	}

	public TelaTituloAddEdt() throws ParseException {
		setTitle("Título (INSERÇÃO/EDIÇÃO) - SA System 1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 556);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel valorLbl = new JLabel("Valor (R$)");
		valorLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		valorEdt = new JFormattedTextField(new MaskFormatter("#.###,##"));
		valorEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		valorEdt.setColumns(10);

		JLabel venctoLbl = new JLabel("Vencto");
		venctoLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		venctoEdt = new JFormattedTextField(new MaskFormatter("##/##/####"));
		venctoEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		venctoEdt.setColumns(10);

		JLabel bancoLbl = new JLabel("Banco");
		bancoLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		bancoEdt = new JTextField();
		bancoEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		bancoEdt.setColumns(10);

		JLabel fornecedorLbl = new JLabel("Fornecedor");
		fornecedorLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		JLabel descricaoLbl = new JLabel("Descrição dos Produtos e/ou Serviços");
		descricaoLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		descricaoEdt = new JTextField();
		descricaoEdt.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		descricaoEdt.setColumns(10);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				telaPrincipal.setVisible(true);
			}
		});

		fornecedorComboBox = new JComboBox();
		fornecedorComboBox.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		JButton salvarBtn = new JButton("Salvar");
		salvarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					if (tituloParaEdicao != null) {
						tituloParaEdicao.setValor(BigDecimal.valueOf(Double.parseDouble(valorEdt.getText())));
						tituloParaEdicao.setDescricao(descricaoEdt.getText());
						tituloParaEdicao.setDataVencimento(getDataVencimento());
						tituloParaEdicao.setFornecedor((Fornecedor) fornecedorComboBox.getSelectedItem());
						tituloParaEdicao.setNomeBanco(bancoEdt.getText());
						tituloClient.alterar(tituloParaEdicao);
						JOptionPane.showMessageDialog(null, "Titulo alterado com sucesso!");
					} else {
						Titulo tituloNovo = new Titulo();
						tituloNovo.setValor(BigDecimal.valueOf(Double.parseDouble(valorEdt.getText())));
						tituloNovo.setDescricao(descricaoEdt.getText());
						tituloNovo.setDataVencimento(getDataVencimento());
						tituloNovo.setFornecedor((Fornecedor) fornecedorComboBox.getSelectedItem());
						tituloNovo.setNomeBanco(bancoEdt.getText());
						tituloClient.inserir(tituloNovo);
						JOptionPane.showMessageDialog(null, "Titulo inserido com sucesso!");
					}
				} catch (RestClientResponseException ex) {
					JOptionPane.showMessageDialog(contentPane, formatException(ex.getResponseBodyAsString()));
				}
			}
		});
		salvarBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 15));

		JButton consultarBtn = new JButton("Consultar");
		consultarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaListagem.setVisible(true);
			}
		});
		consultarBtn.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(descricaoEdt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
						.addComponent(fornecedorComboBox, 0, 637, Short.MAX_VALUE)
						.addComponent(descricaoLbl, Alignment.LEADING).addComponent(fornecedorLbl, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(valorEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(valorLbl))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(venctoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(venctoLbl))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(bancoLbl)
										.addComponent(bancoEdt, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))
						.addComponent(consultarBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(salvarBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(consultarBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(valorLbl)
								.addComponent(venctoLbl).addComponent(bancoLbl))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(valorEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(venctoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(bancoEdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE).addComponent(fornecedorLbl)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(fornecedorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(descricaoLbl)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(descricaoEdt, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addGap(27).addComponent(salvarBtn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] { salvarBtn, consultarBtn });
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { salvarBtn, consultarBtn });
		contentPane.setLayout(gl_contentPane);
	}

	public void inicializar(Titulo tituloInitEdicao) {
		if (tituloInitEdicao != null) {
			valorEdt.setText(tituloInitEdicao.getValor().toString());
			venctoEdt.setText(tituloInitEdicao.getDataVencimento().getDayOfMonth() + "/"
					+ tituloInitEdicao.getDataVencimento().getMonthValue() + "/"
					+ tituloInitEdicao.getDataVencimento().getYear());
			bancoEdt.setText(tituloInitEdicao.getNomeBanco());
			descricaoEdt.setText(tituloInitEdicao.getDescricao());
			fornecedorComboBox.setSelectedItem(tituloInitEdicao.getFornecedor());
			tituloParaEdicao = tituloInitEdicao;
		}
		preencherFornecedorCombobox();
	}

	public void preencherFornecedorCombobox() {
		for (Fornecedor f : fornecedorClient.listar()) {
			fornecedorComboBox.addItem(f);
		}
	}

	public LocalDate getDataVencimento() {
		String[] diaMesAno = venctoEdt.getText().split("/");
		Integer ano = Integer.parseInt(diaMesAno[2]);
		Integer mes = Integer.parseInt(diaMesAno[1]);
		Integer dia = Integer.parseInt(diaMesAno[0]);

		return LocalDate.of(ano, mes, dia);
	}
	
	public String formatException(String excpetion) {
		String[] exceptionFields = excpetion.split("\"");
		
		return exceptionFields[7];
	}
}