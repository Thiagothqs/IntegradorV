package com.projetov.service;

import java.util.List;

import com.projetov.dao.ClienteDAO;
import com.projetov.model.Cliente;
import com.projetov.model.ValidadorCPF;

public class ClienteService {
	ClienteDAO dao = new ClienteDAO();
	ValidadorCPF cpf = new ValidadorCPF();
	
	public void cadastrarCliente(Cliente cliente) {	
		dao.cadastrarCliente(cliente);
	}
	
	public void alterarCliente(Cliente cliente) {
		dao.alterarCliente(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return dao.listarClientes();
	}
}
