package br.com.les.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.Troca;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Pedido;

public class TrocaDAO implements IDAO {

	Troca troca = new Troca();
	protected static TrocaDAO instance;
	protected EntityManager em;

	public static TrocaDAO getInstance(){
		if (instance == null){
			instance = new TrocaDAO();
		}

		return instance;
	}
/*
	public TrocaDAO() {
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
		Troca troca = (Troca) entidade;
		try {
			em.getTransaction().begin();
			em.persist(troca);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		
		return troca;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();
		Troca troca = (Troca) entidade;
		String filtro = troca.getCodigo();

		String sql = "FROM " + Troca.class.getName(); 
		if(filtro!="") {
			sql =sql + " WHERE codigo like :paramNome OR status :paramNome"
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
		return em.find(Troca.class, id);

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		Troca troca = (Troca) entidade;
		try {
			em.getTransaction().begin();
			em.merge(troca);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			em.close();
		}
		em.close();

	}

	
	
	@Override
	public void excluir(EntidadeDominio entidade) {
		em = getEntityManager();
		// TODO Auto-generated method stub
		em.close();
	}
	
	public List<EntidadeDominio> findListByIdCliente(int id_cliente) {
		em = getEntityManager();
		String sql = "FROM " + Troca.class.getName(); 
		sql =sql + " WHERE id_cliente = :paramNome"	;
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", id_cliente);
		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;
	}
	

}

