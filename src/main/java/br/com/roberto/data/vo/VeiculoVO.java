package br.com.roberto.data.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import br.com.roberto.data.model.Cor;

@JsonPropertyOrder({"identificador", "tipo_veiculo", "cor"})
public class VeiculoVO extends ResourceSupport implements Serializable {
	
	private static final long serialVersionUID = -7677618591223745165L;

	@JsonProperty("identificador")
	@Mapping("id")
	private Long identificador;
	
	
	@JsonProperty("tipo_veiculo")
	private String tipoVeiculo;
	
	@JsonProperty("cor")
	private CorVO corVO;


}
