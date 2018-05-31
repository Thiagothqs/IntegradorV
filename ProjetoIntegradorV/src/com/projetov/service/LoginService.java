package com.projetov.service;

import com.projetov.dao.LoginDAO;

public class LoginService {
	LoginDAO dao = new LoginDAO();
	
	public void login(String email, String senha) {
		dao.listaCliente(email, senha);
	}
}
