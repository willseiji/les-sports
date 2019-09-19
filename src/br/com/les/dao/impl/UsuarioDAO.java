package br.com.les.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.les.dao.ConnectionFactory;
import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Usuario;

public class UsuarioDAO implements IDAO {

	Usuario usuario = new Usuario();
	protected static UsuarioDAO instance;
	protected EntityManager em;

	public static UsuarioDAO getInstance(){
		if (instance == null){
			instance = new UsuarioDAO();
		}

		return instance;
	}
/*
	public UsuarioDAO() {
		em = getEntityManager();
	}
*/
	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("les");

//		if (em == null) {
			em = emf.createEntityManager();
		//}

		return em;
	}

	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		em = getEntityManager();
		Usuario usuario = (Usuario) entidade;
		
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.flush();
			em.getTransaction().commit();			
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			
		}
		em.close();

		return usuario;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();
		Usuario u = (Usuario) entidade;
		String nome = u.getNome();
		String senha = u.getSenha();


		String sql = "FROM " + Usuario.class.getName() + " WHERE nome like :paramNome and senha like: paramSenha"; 
		
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", "%"+nome+"%");
		query.setParameter("paramSenha", "%"+senha+"%");

		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;

	}

	@Override
	public EntidadeDominio prealterar(int id) {
		em = getEntityManager();
		Usuario usuario =  em.find(Usuario.class, id);
		em.close();
		return usuario;

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		Usuario usuario = (Usuario) entidade;
		

		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			
		}
		em.close();
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		em = getEntityManager();
		// TODO Auto-generated method stub
		em.close();
	}


}
