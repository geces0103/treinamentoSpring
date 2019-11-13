package br.com.ultracar.treinamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TreinamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoApplication.class, args);
	}

}
