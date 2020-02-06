package br.com.roberto.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.operacoes.Operacoes;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@RequestMapping(value="/somar/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double somar(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws Exception {
		Operacoes o = new Operacoes();
		return o.somar(numeroUm, numeroDois);
	}
	
	@RequestMapping(value="/subtrair/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double subtrair(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws Exception {
		Operacoes o = new Operacoes();
		return o.subtrair(numeroUm, numeroDois);
	}
	
	@RequestMapping(value="/multiplicar/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double multiplicar(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws Exception {
		Operacoes o = new Operacoes();
		return o.multiplicar(numeroUm, numeroDois);
	}
	
	@RequestMapping(value="/dividir/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double dividir(@PathVariable("numeroUm") String numeroUm, @PathVariable("numeroDois") String numeroDois) throws Exception {
		Operacoes o = new Operacoes();
		return o.dividir(numeroUm, numeroDois);
	}
	
	@RequestMapping(value="/raiz/{numero}", method=RequestMethod.GET)
	public Double calcularRaiz(@PathVariable("numeroUm") String numero) throws Exception {
		Operacoes o = new Operacoes();
		return o.calcularRaiz(numero);
	}

}
