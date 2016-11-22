package br.com.model.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.domain.Cliente;
import br.com.model.domain.Endereco;
import br.com.model.service.ClienteService;
import br.com.model.service.exception.NomeClienteJaCadastradoException;
import br.com.model.util.cdi.jsf.FacesUtil;

@Named
@ViewScoped
public class ClientesManager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	transient private ClienteService service;
	
	private List<Endereco> enderecos;
	
	@Inject
	private Cliente clienteEdicao;
	
	private Endereco enderecoEdicao;

	@PostConstruct
	public void inicializar(){
		this.enderecos = new ArrayList<Endereco>();
	}
	
	//FacesUtil.atualizaTela(new String[]{"frm:fabricantes-Table","frm:messages"});
	public void salvar(){
		try {
			this.clienteEdicao.setEnderecos(enderecos);
			service.salvar(clienteEdicao);
			this.limpar();
			
			FacesUtil.addSuccessMessage("Usuário cadastrado com sucesso!");
		} catch (NomeClienteJaCadastradoException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void adicionarEndereco(){
		enderecos.add(enderecoEdicao);		
	}
	public void limpar(){
		this.clienteEdicao = new Cliente();
		this.enderecos = new ArrayList<Endereco>();
	}
	
	public void novoEndereco() {
		this.enderecoEdicao = new Endereco();
	}
	
	public void novoCliente() {
		this.clienteEdicao = new Cliente();
		//return "CadastroCliente?faces-redirect=true";
	}
	
	public Cliente getClienteEdicao() {
		return clienteEdicao;
	}

	public void setClienteEdicao(Cliente clienteEdicao) {
		this.clienteEdicao = clienteEdicao;
	}

	public Endereco getEnderecoEdicao() {
		return enderecoEdicao;
	}

	public void setEnderecoEdicao(Endereco enderecoEdicao) {
		this.enderecoEdicao = enderecoEdicao;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
