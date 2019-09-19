package br.com.les.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.CartaoCredito;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.FormaPagamento;
import br.com.les.dominio.impl.Produto;

public class FormaPagamentoDAO implements IDAO {

	protected static FormaPagamentoDAO instance;
	protected EntityManager em;

	public static FormaPagamentoDAO getInstance(){
		if (instance == null){
			instance = new FormaPagamentoDAO();
		}

		return instance;
	}
/*
	public FormaPagamentoDAO() {
		em = getEntityManager();
	}
*/
	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("les");

	//	if (em == null) {
			em = emf.createEntityManager();
	//	}

		return em;
	}

	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		em = getEntityManager();
		FormaPagamento formaPgto = (FormaPagamento) entidade;
		
		try {
			em.getTransaction().begin();
			em.persist(formaPgto);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		return formaPgto;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();
		
		FormaPagamento formaPgto = (FormaPagamento) entidade;
		

		String sql = "FROM " + FormaPagamento.class.getName(); 
		Query query = em.createQuery(sql);
		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;

	}

	@Override
	public EntidadeDominio prealterar(int id) {
		em = getEntityManager();
		FormaPagamento formaPgto = em.find(FormaPagamento.class, id);
		em.close();
		return formaPgto;

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		FormaPagamento formaPgto = (FormaPagamento) entidade;
		try {
			em.getTransaction().begin();
			em.merge(formaPgto);
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

