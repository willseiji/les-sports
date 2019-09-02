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
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Usuario;

public class ClienteDAO implements IDAO {

	
	Cliente cliente = new Cliente();
	Usuario usuario = new Usuario();
	protected static ClienteDAO instance;
	protected EntityManager em;

	public static ClienteDAO getInstance(){
		if (instance == null){
			instance = new ClienteDAO();
		}

		return instance;
	}

	public ClienteDAO() {
		em = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("les");

		if (em == null) {
			em = emf.createEntityManager();
		}

		return em;
	}
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		System.out.println("antes de try");
		try {
			System.out.println("dentro de try");
			em.getTransaction().begin();
			System.out.println("antes de persist");
			em.persist(cliente);
			System.out.println("depois de persist");
			em.flush();
			System.out.println("antes de commit");
			em.getTransaction().commit();
			System.out.println("depois de commit");
		} catch (Exception ex) {
			System.out.println("dentro de catch");
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		System.out.println("cliente: "+cliente);
		
		return cliente;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {


		Cliente c = (Cliente) entidade;
		String filtro = c.getNome();


		String sql = "FROM " + Cliente.class.getName(); 
		if(filtro!="") {
			sql =sql + " WHERE nome like :paramNome OR codigo like :paramNome OR email like :paramNome "
					+ "OR rg like :paramNome OR cpf like :paramNome OR status like :paramNome"
					;
		}
		Query query = em.createQuery(sql);
		if(filtro!="") 
			query.setParameter("paramNome", "%"+filtro+"%");

		List<EntidadeDominio> entidades = query.getResultList();
		return entidades;

	}

	@Override
	public EntidadeDominio prealterar(int id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
		System.out.println("------------------------");
		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}
	
	public EntidadeDominio findUsuario(int id_usuario) {
		return em.find(Cliente.class, id_usuario);
	}
}
