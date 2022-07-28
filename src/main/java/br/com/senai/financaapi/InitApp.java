package br.com.senai.financaapi;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import br.com.senai.financaapi.view.TelaFornecedorAddEdt;
import br.com.senai.financaapi.view.TelaFornecedorListagem;
import br.com.senai.financaapi.view.TelaLogin;
import br.com.senai.financaapi.view.TelaPrincipal;
import br.com.senai.financaapi.view.TelaTituloListagem;

@SpringBootApplication
public class InitApp {

	/*
	 * @Autowired private TelaLogin telaLogin;
	 */

	/*
	 * @Autowired private TelaPrincipal telaPrincipal;
	 */

	/*
	 * @Autowired private TelaFornecedorListagem telaFornecedorListagem;
	 */

	/*
	 * @Autowired private TelaFornecedorAddEdt telaFornecedorAddEdt;
	 */

	/*
	 * @Autowired private TelaTituloListagem telaTituloListagem;
	 */

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InitApp.class);
		builder.headless(false);
		builder.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							/*
							 * Tela Login telaLogin.setVisible(true);
							 */

							/*
							 * Tela Principal telaPrincipal.setVisible(true);
							 */

							/*
							 * Tela Fornecedor - Listagem telaFornecedorListagem.setVisible(true);
							 */

							/*
							 * Tela Fornecedor - Adicionar ou editar telaFornecedorAddEdt.setVisible(true);
							 */

							/*
							 * Tela Titulo - Listagem telaTituloListagem.mostrar();
							 */

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				});

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		};
	}

}
