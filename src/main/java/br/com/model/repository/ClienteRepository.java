package br.com.model.repository;

import java.util.Optional;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;


import br.com.model.domain.Cliente;

@Repository(forEntity = Cliente.class)
public interface ClienteRepository extends EntityRepository<Cliente, Long> {

	@Query("select c from Cliente c where c.nome = ?1")
	Optional<Cliente> findByName(String nome);
	
	
	//@Query("select c from Cliente c where c.email = ?1")
	Optional<Cliente> findByEmail(String email);
	
}
