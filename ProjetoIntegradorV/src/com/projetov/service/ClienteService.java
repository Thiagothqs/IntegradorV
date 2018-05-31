package com.projetov.service;

import java.util.List;

import com.projetov.dao.ClienteDAO;
import com.projetov.model.Cliente;

public class ClienteService {
	ClienteDAO dao = new ClienteDAO();
	
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
