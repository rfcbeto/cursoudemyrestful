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
	}
}
