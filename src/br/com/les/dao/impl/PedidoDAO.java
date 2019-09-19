package br.com.les.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Item;
import br.com.les.dominio.impl.Pedido;
import br.com.les.dominio.impl.Usuario;

public class PedidoDAO implements IDAO {


	Pedido pedido = new Pedido();
	Cliente cliente = new Cliente();
	protected static PedidoDAO instance;
	protected EntityManager em;

	public static PedidoDAO getInstance(){
		if (instance == null){
			instance = new PedidoDAO();
		}

		return instance;
	}
/*
	public PedidoDAO() {
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
		Pedido pedido = (Pedido) entidade;
		try {
			em.getTransaction().begin();
			em.persist(pedido);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		System.out.println("ID: "+pedido.getId());
		return pedido;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		em = getEntityManager();

		Pedido pedido = (Pedido) entidade;
		String filtro = pedido.getFiltro();
		String id_cliente = Integer.toString(pedido.getId_cliente());


		String sql = "FROM " + Pedido.class.getName(); 
		if(filtro!="") {
			sql =sql + " WHERE codigoPedido like :paramNome OR pedido.id_cliente like :paramId_Cliente"
					;
		}
		Query query = em.createQuery(sql);
		if(filtro!="") {
			query.setParameter("paramNome", "%"+filtro+"%");
			query.setParameter("paramId_Cliente", "%"+id_cliente+"%");
			
		}

		List<EntidadeDominio> entidades = query.getResultList();
		em.close();		
		
		return entidades;

	}

	@Override
	public EntidadeDominio prealterar(int id) {
		em = getEntityManager();
		Pedido pedido = em.find(Pedido.class, id);
		em.close();
		return pedido;
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		em = getEntityManager();
		Pedido pedido = (Pedido) entidade;
		
		System.out.println("------------------------");
		try {
			em.getTransaction().begin();
			em.merge(pedido);
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
	
	public EntidadeDominio findPedido(int id_cliente) {
		em = getEntityManager();
		Pedido pedido =  em.find(Pedido.class, id_cliente);
		em.close();
		return pedido;
	}
	
	public List<EntidadeDominio> findListByIdCliente(int id_cliente) {
		em = getEntityManager();
		String sql = "FROM " + Pedido.class.getName(); 
		sql =sql + " WHERE id_cliente = :paramNome"	;
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", id_cliente);
		return query.getResultList();
		
	}
	
	

}
