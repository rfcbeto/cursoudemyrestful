package br.com.roberto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Gerir Pessoa V2"},description = "Função para gerenciar e manipular dados de pessoa no banco." )
@RestController
@RequestMapping("/api/v2/pessoa")
public class PessoaControllerV2 {

	@Autowired
	private PessoaService service;
	
	@ApiOperation("Recupear pessoa por ID")
	@GetMapping(value="/{id}")
	public PessoaVO findById(@PathVariable("id")String id) throws PessoaException {
		if (id != null) {
			return service.findById(Long.valueOf(id));
		}
		throw new PessoaException(DataUtil.ddMMyyyhhmmss24H(), "Erro", "Valor inválido!");
	}
	
	@ApiOperation("Recupear todas as pessoa da base paginado")
	@GetMapping(value="/listartodos")
	public ResponseEntity<List<PessoaVO>> findAll(Pageable pageable) throws PessoaException{
		return new ResponseEntity<>(service.retornaPessoas(pageable), HttpStatus.OK);
	}
	
	@ApiOperation("Criar uma nova pessoa")
	@PostMapping(value="/criar")
	public PessoaVO criar(@RequestBody PessoaVO pessoa){
		return service.criar(pessoa);
	}
	
	@ApiOperation("Atualizar os dados de uma pessoa")
	@PutMapping(value = "/atualizar")
	public PessoaVO atualizar(@RequestBody PessoaVO pessoa){
		return service.atualizar(pessoa);
	}

	@ApiOperation("Excluir os dados de uma pessoa")
	@DeleteMapping(value = "/excluir/{id}")
	public void excluir(@PathVariable("id")String idPessoa) throws PessoaException{
		if (idPessoa != null) {
			service.excluir(Long.valueOf(idPessoa));
		} else {
			throw new PessoaException(DataUtil.ddMMyyyhhmmss24H(), "Erro", "Pessoa inválida");
		}
	}
}
