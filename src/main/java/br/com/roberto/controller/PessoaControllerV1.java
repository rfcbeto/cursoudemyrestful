package br.com.roberto.controller;

import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
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

import br.com.roberto.data.vo.ListaPessoaVO;
import br.com.roberto.data.vo.PessoaVO;
import br.com.roberto.exceptions.PessoaException;
import br.com.roberto.service.PessoaService;
import br.com.roberto.util.DataUtil;

@RestController
@RequestMapping("/pessoa/v1")
public class PessoaControllerV1 {

	@Autowired
	private PessoaService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PessoaVO> findById(@PathVariable("id")String id) throws PessoaException {
		if (id != null) {
			PessoaVO pessoaVO = service.findById(Long.valueOf(id));
			pessoaVO.add(linkTo(methodOn(PessoaControllerV1.class).findById(id)).withSelfRel());
			return new ResponseEntity<PessoaVO>(pessoaVO, HttpStatus.OK);
		}
		return new ResponseEntity<PessoaVO>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/listartodos")
	public ResponseEntity<ListaPessoaVO> findAll(Pageable pageble) throws PessoaException{
		ListaPessoaVO lpessoa = new ListaPessoaVO();
		List<PessoaVO> lRetorno = service.retornaPessoas(pageble);
		if (!lRetorno.isEmpty()) {
			lpessoa.getPessoas().addAll(lRetorno);
			lRetorno.stream().forEachOrdered(p -> p.add(linkTo(methodOn(PessoaControllerV1.class).findById(String.valueOf(p.getIdentificador()))).withSelfRel()));
			return new ResponseEntity<ListaPessoaVO>(lpessoa, HttpStatus.OK);
		}
		return new ResponseEntity<ListaPessoaVO>(HttpStatus.NOT_FOUND);
	}
	

	@PostMapping(value="/criar")
	public ResponseEntity<PessoaVO> criar(@RequestBody PessoaVO pessoa){
		PessoaVO pessoaVO = service.criar(pessoa); 
		pessoaVO.add(linkTo(methodOn(PessoaControllerV1.class).findById(String.valueOf(pessoaVO.getIdentificador()))).withSelfRel());
		return new ResponseEntity<PessoaVO>(pessoaVO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizar")
	public ResponseEntity<PessoaVO> atualizar(@RequestBody PessoaVO pessoa){
		PessoaVO pessoaVO = service.atualizar(pessoa); 
		pessoaVO.add(linkTo(methodOn(PessoaControllerV1.class).findById(String.valueOf(pessoaVO.getIdentificador()))).withSelfRel());
		return new ResponseEntity<PessoaVO>(pessoaVO, HttpStatus.OK);
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
