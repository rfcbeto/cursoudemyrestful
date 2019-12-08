package br.com.roberto.exceptions;

import java.io.Serializable;
import java.util.Date;

public class CalculadoraException implements Serializable {
	private static final long serialVersionUID = 6488581961032923984L;
	
	private String data;
	private String mensagem;
	private String descricao;
	
	public CalculadoraException(String data, String mensagem, String descricao) {
		super();
		this.data = data;
		this.mensagem = mensagem;
		this.descricao = descricao;
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
