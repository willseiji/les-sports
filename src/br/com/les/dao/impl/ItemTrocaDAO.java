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
import br.com.les.dominio.impl.ItemTroca;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Troca;

public class ItemTrocaDAO implements IDAO {

	protected static ItemTrocaDAO instance;
	protected EntityManager em;

	public static ItemTrocaDAO getInstance(){
		if (instance == null){
			instance = new ItemTrocaDAO();
		}

		return instance;
	}
/*
	public ItemTrocaDAO() {
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
		ItemTroca itemTroca = (ItemTroca) entidade;
		try {
			em.getTransaction().begin();
			em.persist(itemTroca);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		return itemTroca;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();
		ItemTroca itemTroca = (ItemTroca) entidade;
		

		String sql = "FROM " + ItemTroca.class.getName(); 
		Query query = em.createQuery(sql);

		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;

	}

	@Override
	public EntidadeDominio prealterar(int id) {
		em = getEntityManager();
		return em.find(ItemTroca.class, id);

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		ItemTroca itemTroca = (ItemTroca) entidade;
		try {
			em.getTransaction().begin();
			em.merge(itemTroca);
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
	
	

	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> findByIdTroca(int id_troca) {
		em = getEntityManager();
		String sql = "FROM " + ItemTroca.class.getName(); 
		sql =sql + " WHERE id_troca = :paramNome"	;
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", id_troca);
		List<EntidadeDominio> entidades = query.getResultList();
		//em.close();
		return entidades;
	}
	

}

