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

	public ItemDAO() {
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
		
		return item;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {


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
		return entidades;

	}

	@Override
	public EntidadeDominio prealterar(int id) {
		return em.find(Item.class, id);
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
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

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}
	
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> findByIdPedido(int id_pedido) {
		
		System.out.println("id_pedido no findByIdPedido: "+id_pedido);
		
		String sql = "FROM " + Item.class.getName(); 
		sql =sql + " WHERE id_pedido = :paramNome"	;
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", id_pedido );
		
		List<EntidadeDominio> entidades = query.getResultList();
		return entidades;
	}
	
	
	public EntidadeDominio findItem(int id_produto) {
		return em.find(Item.class, id_produto);
	}
}
