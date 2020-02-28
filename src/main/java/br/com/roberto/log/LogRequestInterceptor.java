package br.com.roberto.log;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LogRequestInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LogRequestInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		long horaInicio = Instant.now().toEpochMilli();
		logger.info("URL Request:: "+request.getRequestURL().toString() +" :: Hora Requisição = "+Instant.now());
		request.setAttribute("horaInicio", horaInicio);
		return true;
	}
	
	public void aposRequisicao(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		long horaInicio = (Long) request.getAttribute("horaInicio");
		logger.info("URL Request:: "+request.getRequestURL().toString() + " :: Tempo execução = "+(Instant.now().toEpochMilli() - horaInicio));
	}
}
