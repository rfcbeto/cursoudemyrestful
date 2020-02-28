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
	
	@GetMapping(value="/listartodos", produces = {"application/json", "application/xml"})
	public ResponseEntity<ListaPessoaVO> findAll(Pageable pageble) throws PessoaException{
		ListaPessoaVO lpessoa = new ListaPessoaVO();
		List<PessoaVO> lRetorno = service.retornaPessoas(pageble);
		if (!lRetorno.isEmpty()) {
			lpessoa.getPessoas().addAll(lRetorno);
			return new ResponseEntity<ListaPessoaVO>(lpessoa, HttpStatus.OK);
		}
		return new ResponseEntity<ListaPessoaVO>(HttpStatus.NOT_FOUND);
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
