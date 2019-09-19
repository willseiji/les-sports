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
import br.com.les.dominio.impl.Cupom;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Pedido;
import br.com.les.dominio.impl.Produto;

public class CupomDAO implements IDAO {

	Cupom cupom = new Cupom();
	protected static CupomDAO instance;
	protected EntityManager em;

	public static CupomDAO getInstance(){
		if (instance == null){
			instance = new CupomDAO();
		}

		return instance;
	}

	//public ProdutoDAO() {
		//em = getEntityManager();
//	}

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("les");

		//if (em == null) {
			em = emf.createEntityManager();
		//}

		return em;
	}

	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		em = getEntityManager();
		Cupom cupom = (Cupom) entidade;
		try {
			em.getTransaction().begin();
			em.persist(cupom);
			em.flush();
			em.getTransaction().commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			
		}
		em.close();
		return cupom;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();
		Cupom c = (Cupom) entidade;
		String filtro = c.getCodigo();


		String sql = "FROM " + Cupom.class.getName(); 
		if(filtro!="") {
			sql =sql + " WHERE codigo like :paramNome"
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
		Cupom cupom = em.find(Cupom.class, id);
		em.close();
		return cupom;

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		Cupom cupom = (Cupom) entidade;
		try {
			em.getTransaction().begin();
			em.merge(cupom);
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
	
	public List<EntidadeDominio> findListByIdCliente(int id_cliente) {
		em = getEntityManager();
		String sql = "FROM " + Cupom.class.getName(); 
		sql =sql + " WHERE id_cliente = :paramNome"	;
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", id_cliente);
		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;
	}
	

}

