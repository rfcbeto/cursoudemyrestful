package br.com.roberto.converter.mock;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.roberto.data.vo.ListaPessoaVO;
import br.com.roberto.data.vo.PessoaVO;


public class PessoaMock {
	
	public ListaPessoaVO findAll(){
		PessoaVO pVO = new PessoaVO();
		
		pVO.setIdentificador(1L);
		pVO.setPrimeiroNome("Roberto");
		pVO.setUltimoNome("Coelho");
		pVO.setLogradouro("Rua Jose dos santos lage, 123, Belo Horizonte - MG");
		pVO.setGenero("M");
		
		ListaPessoaVO lp = new ListaPessoaVO();
		lp.setPessoas(List.of(pVO));
		
		return lp;
	}
}
