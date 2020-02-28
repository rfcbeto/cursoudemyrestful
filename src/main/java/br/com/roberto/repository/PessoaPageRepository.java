package br.com.roberto.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.roberto.data.model.Pessoa;

@Repository
public interface PessoaPageRepository extends PagingAndSortingRepository<Pessoa, Long> {

}
