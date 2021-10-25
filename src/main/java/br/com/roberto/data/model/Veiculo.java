package br.com.roberto.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_VEICULO")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -3654466502724508563L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ_VEICULO")
	private Long id;
	
	@Column(name = "TIPO_VEICULO", nullable = false)
	private String tipoVeiculo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="SEQ_COR")
	private Cor cor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
}
