package br.com.roberto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class InicializaSpringboot {

	public static void main(String[] args) {
		SpringApplication.run(InicializaSpringboot.class, args);
		

/* Algoritmo usado para codificar a senha. 		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		String result = bCryptPasswordEncoder.encode("admin123");
		System.out.println("Hash senha: " + result);
*/		
	}
}
