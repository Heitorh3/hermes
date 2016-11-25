package br.com.model.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.domain.Cliente;
import br.com.model.domain.Endereco;
import br.com.model.repository.ClienteRepository;
import br.com.model.service.ClienteService;
import br.com.model.service.exception.NomeClienteJaCadastradoException;
import br.com.model.util.cdi.jsf.FacesUtil;

@Named
@ViewScoped
public class ClientesManager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	transient private ClienteService service;
	
	@Inject
	private ClienteRepository repository;
	
	private List<Cliente> clientes;
	
	@Inject
	private Cliente clienteEdicao;
	
	private Cliente clienteSelecionado;
	
	private Endereco enderecoEdicao;

	@PostConstruct
	public void inicializar(){
		this.clientes = repository.findAll();
	}
	
	//FacesUtil.atualizaTela(new String[]{"frm:fabricantes-Table","frm:messages"});
	public void salvar(){
		try {
			service.salvar(clienteEdicao);
			this.limpar();
			
			this.inicializar();
			FacesUtil.addSuccessMessage("Usuário salvo com sucesso!");
		} catch (NomeClienteJaCadastradoException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void limpar(){
		this.clienteEdicao = new Cliente();
		FacesUtil.atualizaTela(new String[]{"frm:toolbar","frm:messages"});
	}
	
	public void novoEndereco() {
		this.enderecoEdicao = new Endereco();
	}
	
	public void novoCliente() {
		this.clienteEdicao = new Cliente();
		this.clienteSelecionado = null;
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

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
