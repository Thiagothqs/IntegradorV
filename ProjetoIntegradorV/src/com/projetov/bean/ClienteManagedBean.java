package com.projetov.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.projetov.model.Cliente;
import com.projetov.model.ValidadorCPF;
import com.projetov.service.ClienteService;

@ManagedBean (name="clienteManagedBean")
@SessionScoped
public class ClienteManagedBean implements Serializable{
	private static final long serialVersionUID = 5411259097670843925L;

	private ValidadorCPF cpf;
	private Cliente cliente;
	private ClienteService service;
	//private boolean retorno;

	public ClienteManagedBean() {
		cliente = new Cliente();
		service = new ClienteService();
	}
	
	public void abrirJogo(){
		try 
		{   
		    String comando = "C:\\Users\\Lenovo\\Desktop\\MazeRunner\\MazeRunner.exe";   
		    Process processo = Runtime.getRuntime().exec(comando);
		} 
		catch (IOException e) 
		{
		   System.out.println("Erro: "+e.getMessage()+"\n"+e.getCause());   
		}
	}
	
	public String cadastrarCliente() {
		if(cpf.isCPF(cliente.getCpf()) == true) {
			service.cadastrarCliente(cliente);
			return "index";
		}
		else {
			FacesContext.getCurrentInstance().addMessage(":cadastro:erro", new FacesMessage(FacesMessage.SEVERITY_WARN, "CPF Inválido", "CPF Inválido"));  
			return "";
		}
	}

	public String alterarCliente() {
		service.alterarCliente(cliente);
		return "index";
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ClienteService getService() {
		return service;
	}
	public void setService(ClienteService service) {
		this.service = service;
	}
	public ValidadorCPF getCpf() {
		return cpf;
	}

	public void setCpf(ValidadorCPF cpf) {
		this.cpf = cpf;
	}
	
}
