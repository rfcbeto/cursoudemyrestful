package br.com.roberto.enums;

public enum SexoEnum {

	M(1, "MASCULINO"), 
	F(2, "FEMININO");
	
	public String valor;
	public int codigo;
	
	private SexoEnum(int codigo, String valor) {
		this.valor = valor;
		this.codigo = codigo;
	}
	
	public int getValor() {
		return this.codigo;
	}
}
