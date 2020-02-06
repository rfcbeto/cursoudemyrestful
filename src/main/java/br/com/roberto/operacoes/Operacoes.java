package br.com.roberto.operacoes;

import br.com.roberto.exceptions.OperacaoNaoSuportada;
import br.com.roberto.util.NumeroUtil;

public class Operacoes {

	public Double somar(String numeroUm, String numeroDois) throws Exception {
		if (!NumeroUtil.isNumeric(numeroUm) || !NumeroUtil.isNumeric(numeroDois)) {
			throw new OperacaoNaoSuportada("Favor informar um valor numérico!");
		}
		return NumeroUtil.convertToDouble(numeroUm) + NumeroUtil.convertToDouble(numeroDois);
	}
	
	public Double subtrair(String numeroUm, String numeroDois) throws Exception {
		if (!NumeroUtil.isNumeric(numeroUm) || !NumeroUtil.isNumeric(numeroDois)) {
			throw new OperacaoNaoSuportada("Favor informar um valor numérico!");
		}
		return NumeroUtil.convertToDouble(numeroUm) - NumeroUtil.convertToDouble(numeroDois);
	}
	
	public Double multiplicar(String numeroUm, String numeroDois) throws Exception {
		if (!NumeroUtil.isNumeric(numeroUm) || !NumeroUtil.isNumeric(numeroDois)) {
			throw new OperacaoNaoSuportada("Favor informar um valor numérico!");
		}
		return NumeroUtil.convertToDouble(numeroUm) * NumeroUtil.convertToDouble(numeroDois);
	}
	
	public Double dividir(String numeroUm, String numeroDois) throws Exception {
		if (!NumeroUtil.isNumeric(numeroUm) || !NumeroUtil.isNumeric(numeroDois)) {
			throw new OperacaoNaoSuportada("Favor informar um valor numérico!");
		}
		return NumeroUtil.convertToDouble(numeroUm) / NumeroUtil.convertToDouble(numeroDois);
	}
	
	public Double calcularRaiz(String numero) throws Exception {
		return Math.sqrt(NumeroUtil.convertToDouble(numero));
	}
}
