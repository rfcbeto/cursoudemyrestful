package br.com.roberto.data.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_COR_PERSONALIZADA")
public class Cor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ_COR")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TB_COR_PIGMENTO", joinColumns = {@JoinColumn(name = "SEQ_COR")}, 
	inverseJoinColumns = {@JoinColumn(name = "SEQ_PIGMENTO")})
	private List<Pigmento> pigmentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
