package br.com.roberto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.roberto.controller.PessoaControllerV2;
import br.com.roberto.converter.DozerConverter;
import br.com.roberto.converter.PessoaConverter;
import br.com.roberto.data.model.Pessoa;
import br.com.roberto.data.vo.PessoaVO;
import br.com.roberto.exceptions.PessoaException;
import br.com.roberto.repository.PessoaPageRepository;
import br.com.roberto.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private PessoaPageRepository pageRepository;
	
	@Autowired
	private PessoaControllerV2 pessoaControllerV2;
	
	public PessoaVO findById(Long idPessoa) throws PessoaException{
		return DozerConverter.parseObject(repository.findById(idPessoa).orElseThrow(() -> new PessoaException("Pessoa não encontrada")), PessoaVO.class);
	}

	public List<PessoaVO> retornaPessoas(Pageable pageable) throws PessoaException{
		return DozerConverter.parseListObject(pageRepository.findAll(pageable).getContent(), PessoaVO.class);
	}
	
	public List<PessoaVO> retornaPessoasMock(Pageable pageable) throws PessoaException{
		return DozerConverter.parseListObject(pageRepository.findAll(pageable).getContent(), PessoaVO.class);
	}
	
	public PessoaVO criar(PessoaVO pessoaVO) {
		Pessoa pessoa = DozerConverter.parseObject(pessoaVO, Pessoa.class);
		return DozerConverter.parseObject(repository.save(pessoa), PessoaVO.class);
	}

	public void excluir(Long idPessoa) throws PessoaException {
		Pessoa p = repository.findById(idPessoa).orElseThrow(() -> new PessoaException("Pessoa não encontrada"));
		repository.delete(p);
	}

	public PessoaVO atualizar(PessoaVO pessoaVO) {
		Pessoa entidade = repository.findById(pessoaVO.getIdentificador()).orElseThrow(() -> new PessoaException("Pessoa não encontrada"));
		entidade.setGenero(pessoaVO.getGenero());
		entidade.setLogradouro(pessoaVO.getLogradouro());
		entidade.setPrimeiroNome(pessoaVO.getPrimeiroNome());
		entidade.setUltimoNome(pessoaVO.getUltimoNome());
		//return entidade;
		return null;
	}
	
	/* VERSÃO 2. DA API*/
	public Pessoa criarV2(PessoaVO pessoaVO) {
		Pessoa pessoa = PessoaConverter.parseVoToEntity(pessoaVO);
		return PessoaConverter.parseVoToEntity(pessoaVO);
	}
}
