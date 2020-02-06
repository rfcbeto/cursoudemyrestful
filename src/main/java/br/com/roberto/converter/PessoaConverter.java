package br.com.roberto.converter;

import br.com.roberto.data.model.Pessoa;
import br.com.roberto.data.vo.PessoaVO;

public class PessoaConverter {

	//private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static Pessoa parseVoToEntity(PessoaVO pVo) {
		Pessoa entidade = new Pessoa();
		entidade.setId(pVo.getId());
		entidade.setGenero(pVo.getGenero());
		entidade.setLogradouro(pVo.getLogradouro());
		entidade.setPrimeiroNome(pVo.getPrimeiroNome());
		entidade.setUltimoNome(pVo.getUltimoNome());
		return entidade;
	} 
	
	public static PessoaVO parseEntityToVO(Pessoa pessoa) {
		PessoaVO pVo = new PessoaVO();
		pVo.setId(pessoa.getId());
		pVo.setGenero(pessoa.getGenero());
		pVo.setLogradouro(pessoa.getLogradouro());
		pVo.setPrimeiroNome(pessoa.getPrimeiroNome());
		pVo.setUltimoNome(pessoa.getUltimoNome());
		return pVo;
	}
}
