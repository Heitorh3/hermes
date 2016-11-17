package br.com.model.service;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.model.domain.Cliente;
import br.com.model.repository.ClienteRepository;
import br.com.model.service.exception.NomeClienteJaCadastradoException;

public class ClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	static Logger log = LogManager.getLogger(ClienteService.class);
	
	@Inject
	private ClienteRepository clientes;
	
	@Transactional
	public Cliente salvar(Cliente cliente) throws NomeClienteJaCadastradoException{
		Optional<Cliente> clienteExistente = clientes.findByEmail(cliente.getEmail());

		if(clienteExistente.isPresent() && !clienteExistente.get().equals(cliente)){
			log.error("cliente já cadastrado!");
			throw new NomeClienteJaCadastradoException("Cliente já cadastrado!");
		}
			
		log.info("Salvando o cliente!");
		return clientes.save(cliente);
		
	}
}
