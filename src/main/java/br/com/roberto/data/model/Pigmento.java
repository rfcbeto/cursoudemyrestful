package br.com.roberto.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_PIGMENTO")
public class Pigmento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ_PIGMENTO")
	private Long id;
	
	@Column(name="TIPO_PIGMENTO")
	private String tipoPigmento;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="QUANTIDADE")
	private Double quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoPigmento() {
		return tipoPigmento;
	}

	public void setTipoPigmento(String tipoPigmento) {
		this.tipoPigmento = tipoPigmento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
}
