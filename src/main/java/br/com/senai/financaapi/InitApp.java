package br.com.senai.financaapi;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import br.com.senai.financaapi.view.TelaLogin;

@SpringBootApplication
public class InitApp {

	@Autowired
	private TelaLogin telaLogin;

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

							telaLogin.setVisible(true);

						} catch (RestClientException e) {
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
