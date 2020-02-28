package br.com.roberto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.data.vo.PessoaVO;
import br.com.roberto.exceptions.PessoaException;
import br.com.roberto.service.PessoaService;
import br.com.roberto.util.DataUtil;

@RestController
@RequestMapping("/pessoa/v2")
public class PessoaControllerV2 {

	@Autowired
	private PessoaService service;
	
	@GetMapping(value="/{id}")
	public PessoaVO findById(@PathVariable("id")String id) throws PessoaException {
		if (id != null) {
			return service.findById(Long.valueOf(id));
		}
		throw new PessoaException(DataUtil.ddMMyyyhhmmss24H(), "Erro", "Valor inválido!");
	}
	
	@GetMapping(value="/listartodos")
	public List<PessoaVO> findAll(Pageable pageable) throws PessoaException{
		return service.retornaPessoas(pageable);
	}
	
	@PostMapping(value="/criar")
	public PessoaVO criar(@RequestBody PessoaVO pessoa){
		return service.criar(pessoa);
	}
	
	@PutMapping(value = "/atualizar")
	public PessoaVO atualizar(@RequestBody PessoaVO pessoa){
		return service.atualizar(pessoa);
	}

	@DeleteMapping(value = "/excluir/{id}")
	public void excluir(@PathVariable("id")String idPessoa) throws PessoaException{
		if (idPessoa != null) {
			service.excluir(Long.valueOf(idPessoa));
		} else {
			throw new PessoaException(DataUtil.ddMMyyyhhmmss24H(), "Erro", "Pessoa inválida");
		}
	}
}
