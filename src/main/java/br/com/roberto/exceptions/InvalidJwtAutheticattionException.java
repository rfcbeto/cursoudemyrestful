package br.com.roberto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAutheticattionException extends AuthenticationException{
	
	private static final long serialVersionUID = 4263696287835922120L;
	
	public InvalidJwtAutheticattionException(String msg) {
		super(msg);
	}
}
