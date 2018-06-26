package com.projetov.service;

import java.util.List;

import com.projetov.dao.LoginDAO;
import com.projetov.model.Cliente;

public class LoginService {
	LoginDAO dao = new LoginDAO();
	
	public String login(String email, String senha) {
		List<Cliente> listaCliente = dao.listaCliente(email, senha);
		if(!listaCliente.isEmpty()) {
			return "index";
		}
		else {
			return "cadastroCliente";
		}
	}
}
