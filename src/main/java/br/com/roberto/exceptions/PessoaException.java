package br.com.roberto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PessoaException extends RuntimeException{

	private static final long serialVersionUID = 4263696287835922120L;
	private String data;
	private String mensagem;
	private String descricao;
	
	public PessoaException(String data, String mensagem, String descricao) {
		this.data = data;
		this.mensagem = mensagem;
		this.descricao = descricao;
	}

	public PessoaException(String exception) {
		super(exception);
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
