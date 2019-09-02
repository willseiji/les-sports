package br.com.les.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;

public class Produto2DAO  implements IDAO{

	Produto produto = new Produto();
	protected static Produto2DAO instance;
    protected EntityManager em;
     
    public static Produto2DAO getInstance(){
      if (instance == null){
         instance = new Produto2DAO();
      }
       
      return instance;
    }

    public Produto2DAO() {
      em = getEntityManager();
    }

    private EntityManager getEntityManager() {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("les");
     if (em == null) {
       em = emf.createEntityManager();
     }

     return em;
    }
/*
    public Cliente getById(final int id) {
      return entityManager.find(Cliente.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> findAll() {
      return entityManager.createQuery("FROM " + 
      Cliente.class.getName()).getResultList();
    }

    public void persist(Cliente cliente) {
      try {
         entityManager.getTransaction().begin();
         entityManager.persist(cliente);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void merge(Cliente cliente) {
      try {
         entityManager.getTransaction().begin();
         entityManager.merge(cliente);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void remove(Cliente cliente) {
      try {
         entityManager.getTransaction().begin();
         cliente = entityManager.find(Cliente.class, cliente.getId());
         entityManager.remove(cliente);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void removeById(final int id) {
      try {
         Cliente cliente = getById(id);
         remove(cliente);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
    }

	*/
	
	
    @Override
	public int salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Produto produto = (Produto) entidade;
	      try {
	          em.getTransaction().begin();
	          em.persist(produto);
	          em.getTransaction().commit();
	       } catch (Exception ex) {
	          ex.printStackTrace();
	          em.getTransaction().rollback();
	       }
		
		return 0;
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		Produto p = (Produto) entidade;
		int id = p.getId();
		return em.createQuery("FROM " + Produto.class.getName()+" WHERE id =" + id).getResultList();
	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		Produto p = (Produto) entidade;
		int id = p.getId();
		try {
	         Produto produto = getById(id);
	         remove(produto);
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }

	}
	
	public Produto getById(final int id) {
	      return em.find(Produto.class, id);
	    }

	public void remove(Produto produto) {
	      try {
	         em.getTransaction().begin();
	         produto = em.find(Produto.class, produto.getId());
	         em.remove(produto);
	         em.getTransaction().commit();
	      } catch (Exception ex) {
	         ex.printStackTrace();
	         em.getTransaction().rollback();
	      }
	    }


}
