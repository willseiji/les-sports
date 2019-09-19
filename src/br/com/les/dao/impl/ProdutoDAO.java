package br.com.les.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.les.dao.ConnectionFactory;
import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;

public class ProdutoDAO implements IDAO {

	Produto produto = new Produto();
	protected static ProdutoDAO instance;
	protected EntityManager em;

	public static ProdutoDAO getInstance(){
		if (instance == null){
			instance = new ProdutoDAO();
		}

		return instance;
	}

	//public ProdutoDAO() {
		//em = getEntityManager();
//	}

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("les");

//		if (em == null) {
			em = emf.createEntityManager();
//		}

		return em;
	}

	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		em = getEntityManager();
		Produto produto = (Produto) entidade;
		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.flush();
			em.getTransaction().commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			
		}
		em.close();
		return produto;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();
		Produto p = (Produto) entidade;
		String filtro = p.getDescricao();


		String sql = "FROM " + Produto.class.getName(); 
		if(filtro!="") {
			sql =sql + " WHERE nome like :paramNome OR codigo like :paramNome "
					+ "OR fabricante like :paramNome OR material like :paramNome OR categoria like :paramNome"
					;
		}
		Query query = em.createQuery(sql);
		if(filtro!="") 
			query.setParameter("paramNome", "%"+filtro+"%");

		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;

	}

	@Override
	public EntidadeDominio prealterar(int id) {
		em = getEntityManager();
		Produto produto = em.find(Produto.class, id);
		em.close();
		return produto;

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		Produto produto = (Produto) entidade;

		try {
			em.getTransaction().begin();
			em.merge(produto);
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

