package br.com.roberto.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.roberto.data.model.Veiculo;

@Repository
public interface VeiculoPageRepository extends PagingAndSortingRepository<Veiculo, Long> {

}
