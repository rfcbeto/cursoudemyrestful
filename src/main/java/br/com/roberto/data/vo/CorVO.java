package br.com.roberto.data.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import br.com.roberto.data.model.Pigmento;

@JsonPropertyOrder({"identificador", "nome", "pigmentos"})
public class CorVO {

	@JsonProperty("identificador")
	@Mapping("id")
	private Long identificador;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("pigmentos")
	private List<Pigmento> pigmentos;


	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pigmento> getPigmentos() {
		return pigmentos;
	}

	public void setPigmentos(List<Pigmento> pigmentos) {
		this.pigmentos = pigmentos;
	}
}
