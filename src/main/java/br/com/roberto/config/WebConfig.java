package br.com.roberto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		// CONFIGURAÇÃO PARA ACEITAR JSON E XML POR EXTENSÃO.
/*
		configurer.favorParameter(false)
		 .ignoreAcceptHeader(false)
		 .defaultContentType(MediaType.APPLICATION_JSON)
		 .mediaType("JSON", MediaType.APPLICATION_JSON)
		 .mediaType("XML", MediaType.APPLICATION_XML);
*/
		// CONFIGURAÇÃO PARA ACEITAR JSON E XML POR PARAMETRO. "mediaType"
/*		
		 configurer.favorPathExtension(false)
		 .favorParameter(true)
		 .parameterName("mediaType")
		 .ignoreAcceptHeader(true)
		 .useRegisteredExtensionsOnly(false)
		 .defaultContentType(MediaType.APPLICATION_JSON)
		 .mediaType("JSON", MediaType.APPLICATION_JSON)
		 .mediaType("XML", MediaType.APPLICATION_XML);
*/		 
		// CONFIGURAÇÃO PARA ACEITAR JSON E XML POR CABEÇALHO. "header"
		 configurer.favorPathExtension(false)
		 .favorParameter(false)
		 .ignoreAcceptHeader(false)
		 .useRegisteredExtensionsOnly(false)
		 .defaultContentType(MediaType.APPLICATION_JSON)
		 .mediaType("JSON", MediaType.APPLICATION_JSON)
		 .mediaType("XML", MediaType.APPLICATION_XML);
	}
}
