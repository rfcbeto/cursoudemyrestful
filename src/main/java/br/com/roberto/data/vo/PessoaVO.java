package br.com.roberto.data.vo;

import java.io.Serializable;

public class PessoaVO implements Serializable{
	
	private static final long serialVersionUID = 6912081931710088918L;
	
	private Long id;
	private String primeiroNome;
	private String ultimoNome;
	private String logradouro;
	private String genero;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((primeiroNome == null) ? 0 : primeiroNome.hashCode());
		result = prime * result + ((ultimoNome == null) ? 0 : ultimoNome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaVO other = (PessoaVO) obj;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (primeiroNome == null) {
			if (other.primeiroNome != null)
				return false;
		} else if (!primeiroNome.equals(other.primeiroNome))
			return false;
		if (ultimoNome == null) {
			if (other.ultimoNome != null)
				return false;
		} else if (!ultimoNome.equals(other.ultimoNome))
			return false;
		return true;
	}
}
