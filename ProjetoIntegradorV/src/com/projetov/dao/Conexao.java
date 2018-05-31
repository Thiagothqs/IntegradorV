package com.projetov.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorV");
	
	public static EntityManagerFactory getInstance() {
		return emf;
	}
}