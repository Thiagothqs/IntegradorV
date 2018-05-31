package com.projetov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.projetov.model.Cliente;

public class ClienteDAO {
	EntityManagerFactory emf = Conexao.getInstance();
	
	public void cadastrarCliente(Cliente cliente) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
	}
	
	public void alterarCliente(Cliente cliente) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Cliente> listarClientes() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("FROM Cliente");
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}
	
}
