package br.com.roberto.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.roberto"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("RESTfull API com Spring boot 2.1.x", 
				"Api para estudo e aprendizado da criação de API's", 
				"Versão 1.0", 
				"Particular", 
				new Contact("Roberto França", "https://www.linkedin.com/in/roberto-franca/", "rfcbeto@gmail.com"), 
				"Licença livre", 
				"Licença livre", 
				Collections.emptyList());
	}
}
