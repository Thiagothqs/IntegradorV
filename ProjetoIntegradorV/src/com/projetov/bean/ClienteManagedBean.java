package com.projetov.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projetov.model.Cliente;
import com.projetov.service.ClienteService;

@ManagedBean (name="clienteManagedBean")
@SessionScoped
public class ClienteManagedBean implements Serializable{
	private static final long serialVersionUID = 5411259097670843925L;

	private Cliente cliente;
	private ClienteService service;

	public ClienteManagedBean() {
		cliente = new Cliente();
		service = new ClienteService();
	}
	
	public void abrirJogo(){
		try 
		{   
		    String comando = "C:\\Users\\Lenovo\\Desktop\\Build\\Build.exe";   
		    Process processo = Runtime.getRuntime().exec(comando);   
		} 
		catch (IOException e) 
		{
		   System.out.println("Erro: "+e.getMessage()+"\n"+e.getCause());   
		}
	}
	
	public String cadastrarCliente() {
		System.out.println(cliente.getId() +" O id");
		service.cadastrarCliente(cliente);
		return "index";
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
	
}
