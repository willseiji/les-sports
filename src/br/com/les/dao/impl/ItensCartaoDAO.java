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
import br.com.les.dominio.impl.ItensCartao;
import br.com.les.dominio.impl.Produto;

public class ItensCartaoDAO implements IDAO {

	protected static ItensCartaoDAO instance;
	protected EntityManager em;

	public static ItensCartaoDAO getInstance(){
		if (instance == null){
			instance = new ItensCartaoDAO();
		}

		return instance;
	}
/*
	public ItensCartaoDAO() {
		em = getEntityManager();
	}
*/
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
		ItensCartao itensCartao = (ItensCartao) entidade;
		try {
			em.getTransaction().begin();
			em.persist(itensCartao);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();

		return itensCartao;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();
		ItensCartao itensCartao = (ItensCartao) entidade;
		

		String sql = "FROM " + ItensCartao.class.getName(); 
		Query query = em.createQuery(sql);

		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;

	}

	@Override
	public EntidadeDominio prealterar(int id) {
		em = getEntityManager();
		ItensCartao cartao = em.find(ItensCartao.class, id);
		em.close();
		return cartao;

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		ItensCartao itensCartao = (ItensCartao) entidade;
		try {
			em.getTransaction().begin();
			em.merge(itensCartao);
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

