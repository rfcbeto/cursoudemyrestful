package br.com.roberto.data.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pessoas")
public class ListaPessoaVO implements Serializable{

	private static final long serialVersionUID = -6419984285742044559L;

	@JsonProperty("pessoa")
	private List<PessoaVO> pessoas = new ArrayList<>();

	public List<PessoaVO> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaVO> pessoas) {
		this.pessoas = pessoas;
	}
}
