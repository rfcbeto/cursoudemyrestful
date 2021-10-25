package br.com.roberto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.data.vo.VeiculoVO;
import br.com.roberto.exceptions.PessoaException;
import br.com.roberto.service.VeiculoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "EndPoint_Pessoa",description = "TESTE DESCRIÇÃO", tags = {"Gerir Pessoa"})
@Api(tags="Gerir cores veiculo", description = "Teste dos relacionamentos das tabelas.")
@RestController
@RequestMapping("/api/v1/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService service;
	
	@ApiOperation(value = "Buscar todas os veículos")
	@GetMapping(value="/listartodos")
	public ResponseEntity<VeiculoVO> findAll(Pageable pageble) throws PessoaException{
		VeiculoVO lveiculo = new VeiculoVO();
		List<VeiculoVO> lRetorno = service.buscarVeiculos(pageble);
		if (!lRetorno.isEmpty()) {
			
			return new ResponseEntity<VeiculoVO>(lveiculo, HttpStatus.OK);
		}
		return new ResponseEntity<VeiculoVO>(HttpStatus.NOT_FOUND);
	}
}
