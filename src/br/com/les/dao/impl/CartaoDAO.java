package br.com.les.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.CartaoCredito;
import br.com.les.dominio.impl.EntidadeDominio;

public class CartaoDAO implements IDAO {

	CartaoCredito cartao = new CartaoCredito();
	protected static CartaoDAO instance;
	protected EntityManager em;

	public static CartaoDAO getInstance(){
		if (instance == null){
			instance = new CartaoDAO();
		}

		return instance;
	}
/*
	public CartaoDAO() {
		em = getEntityManager();
	}
*/
	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("les");
		//if (em == null) {
			em = emf.createEntityManager();
	//	}

		return em;
	}

	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		em = getEntityManager();
		CartaoCredito cartao = (CartaoCredito) entidade;
		try {
			em.getTransaction().begin();
			em.persist(cartao);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		return cartao;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();
		
		CartaoCredito cartao = (CartaoCredito) entidade;
		String filtro = cartao.getNomeTitular();


		String sql = "FROM " + CartaoCredito.class.getName(); 
		if(filtro!="") {
			sql =sql + " WHERE nome_titular like :paramNome"
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
		CartaoCredito cartao =  em.find(CartaoCredito.class, id);
		em.close();
		return cartao;

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		CartaoCredito cartao = (CartaoCredito) entidade;
		try {
			em.getTransaction().begin();
			em.merge(cartao);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> findByIdCliente(int id_cliente) {
		em = getEntityManager();
		String sql = "FROM " + CartaoCredito.class.getName(); 
		sql =sql + " WHERE id_cliente = :paramNome"	;
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", id_cliente);
		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;
	}
	
	
	@Override
	public void excluir(EntidadeDominio entidade) {
		em = getEntityManager();
		// TODO Auto-generated method stub
		em.close();
	}

}

