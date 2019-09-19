package br.com.les.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Item;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Usuario;

public class ItemDAO implements IDAO {


	Item item = new Item();
	Produto produto = new Produto();
	protected static ItemDAO instance;
	protected EntityManager em;

	public static ItemDAO getInstance(){
		if (instance == null){
			instance = new ItemDAO();
		}

		return instance;
	}
/*
	public ItemDAO() {
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
		Item item = (Item) entidade;
		
		System.out.println("------------------------");
		System.out.println("produto: "+item.getProduto().getNome());
		System.out.println("qtde: "+item.getQtde());
		
		
		try {
			em.getTransaction().begin();
			em.merge(item);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		return item;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();

		Item item = (Item) entidade;
		String filtro = item.getFiltro();

		String sql = "FROM " + Item.class.getName(); 
		if(filtro!="") {
			sql =sql + " WHERE codigoItem like :paramNome "
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
		Item item =  em.find(Item.class, id);
		em.close();
		return item;
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		Item item = (Item) entidade;
		System.out.println("------------------------");
		try {
			em.getTransaction().begin();
			em.merge(item);
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
	public List<EntidadeDominio> findByIdPedido(int id_pedido) {
		em = getEntityManager();
		System.out.println("id_pedido no findByIdPedido: "+id_pedido);
		
		String sql = "FROM " + Item.class.getName(); 
		sql =sql + " WHERE id_pedido = :paramNome"	;
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", id_pedido );
		
		List<EntidadeDominio> entidades = query.getResultList();
		em.close();
		return entidades;
	}
	
	
	public EntidadeDominio findIdProduto(int id_item) {
		em = getEntityManager();
		String sql = "FROM " + Item.class.getName()+ " WHERE id_produto = "+id_item; 

		Query query = em.createQuery(sql);
		return (EntidadeDominio) query.getSingleResult();
	}
}
