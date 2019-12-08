package br.com.roberto.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.exceptions.OperacaoNaoSuportada;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@RequestMapping(value="/soma/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double adicao(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws Exception {
		if (!isNumeric(numeroUm) || !isNumeric(numeroDois)) {
			throw new OperacaoNaoSuportada("Favor informar um valor numérico!");
		}
		return convertToDouble(numeroUm) + convertToDouble(numeroDois);
	}

	private Double convertToDouble(String numero) {
		if(numero == null){
			return 0D;
		} 
		String numeroSemVirgula = numero.replaceAll(",", ".");
		if(isNumeric(numeroSemVirgula)) {
			return Double.valueOf(numeroSemVirgula);
		}
		return 0D;
	}

	private boolean isNumeric(String numero) {
		if(numero == null){
			return false;
		} 
		String numeroSemVirgutla = numero.replaceAll(",", ".");
		return numeroSemVirgutla.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
