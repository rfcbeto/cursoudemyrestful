package br.com.roberto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.roberto.converter.DozerConverter;
import br.com.roberto.data.vo.VeiculoVO;
import br.com.roberto.exceptions.PessoaException;
import br.com.roberto.repository.VeiculoPageRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoPageRepository veiculoRepository;
	
	public List<VeiculoVO> buscarVeiculos(Pageable pageable) throws PessoaException{
		return DozerConverter.parseListObject(veiculoRepository.findAll(pageable).getContent(), VeiculoVO.class);
	}
	
	
}
