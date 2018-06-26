package com.projetov.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projetov.service.LoginService;

@ManagedBean (name="loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {
	private static final long serialVersionUID = -2714775212827731833L;

	private LoginService service;
	private String email;
	private String senha;
	
	public LoginManagedBean() {
		service = new LoginService();
		email = "";
		senha = "";
	}
	
	public String logarCliente() {
		String retorna = "";
		retorna = service.login(email, senha);
		return retorna;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public LoginService getService() {
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}
}
