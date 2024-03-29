package br.com.roberto.exceptions.configuracao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.roberto.exceptions.CalculadoraException;
import br.com.roberto.exceptions.InvalidJwtAutheticattionException;
import br.com.roberto.exceptions.OperacaoNaoSuportada;
import br.com.roberto.exceptions.PessoaException;
import br.com.roberto.util.DataUtil;

@RestController
@ControllerAdvice
public class CustomCalculadoraExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CalculadoraException> handler(Exception ex, WebRequest request) {
		CalculadoraException exception = new CalculadoraException(DataUtil.ddMMyyyhhmmss24H(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<CalculadoraException>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PessoaException.class)
	public final ResponseEntity<PessoaException> handlerPessoaException(PessoaException ex, WebRequest request) {
		PessoaException exception = new PessoaException(DataUtil.ddMMyyyhhmmss24H(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<PessoaException>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OperacaoNaoSuportada.class)
	public final ResponseEntity<CalculadoraException> handlerBadRequestExceptions(Exception ex, WebRequest request) {
		CalculadoraException exception = new CalculadoraException(DataUtil.ddMMyyyhhmmss24H(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<CalculadoraException>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidJwtAutheticattionException.class)
	public final ResponseEntity<CalculadoraException> InvalidJwtAutheticattionException(Exception ex, WebRequest request) {
		CalculadoraException exception = new CalculadoraException(DataUtil.ddMMyyyhhmmss24H(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<CalculadoraException>(exception, HttpStatus.BAD_REQUEST);
	}
}
