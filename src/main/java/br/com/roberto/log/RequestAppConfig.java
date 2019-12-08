package br.com.roberto.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestAppConfig implements WebMvcConfigurer {

	@Autowired
	private LogRequestInterceptor logRequestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logRequestInterceptor).addPathPatterns("/**/calculadora/**/");
	}

}
