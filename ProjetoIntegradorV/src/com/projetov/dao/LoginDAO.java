package com.projetov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.projetov.model.Cliente;


public class LoginDAO {
	EntityManagerFactory emf = Conexao.getInstance();
	
	public List<Cliente> listaCliente(String email, String senha){
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("from Cliente where email = ? and senha = ?");
		q.setParameter(0, email);
		q.setParameter(1, senha);
		
		List<Cliente> listaCliente = q.getResultList();
		
		em.getTransaction().commit();
		
		return listaCliente;
	}
}
