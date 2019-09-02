package br.com.les.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;

public class EnderecoDAO implements IDAO {

	Endereco endereco= new Endereco();
	protected static EnderecoDAO instance;
	protected EntityManager em;

	public static EnderecoDAO getInstance(){
		if (instance == null){
			instance = new EnderecoDAO();
		}

		return instance;
	}

	public EnderecoDAO() {
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
		Endereco endereco = (Endereco) entidade;
		
		System.out.println("rua: "+endereco.getRua());
		System.out.println("numero: "+endereco.getNumero());
		System.out.println("complemento: "+endereco.getComplemento());
		System.out.println("bairro: "+endereco.getBairro());
		System.out.println("cep: "+endereco.getCep());
		System.out.println("cidade: "+endereco.getCidade().getNome());
		System.out.println("estado: "+endereco.getCidade().getEstado().getNome());
		System.out.println("tipo: "+endereco.getTipoEndereco());
		System.out.println("id_cliente: "+endereco.getId_cliente());
		
		try {
			System.out.println("dentro de try");
			em.getTransaction().begin();
			System.out.println("antes de persist");
			em.merge(endereco);
			System.out.println("depois de persist");
			em.flush();
			System.out.println("antes de commit");
			em.getTransaction().commit();
			System.out.println("depois de commit");
		} catch (Exception ex) {
			System.out.println("dentro de catch");
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
		System.out.println("endereco: "+endereco);

		return endereco;


	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {

		Endereco e = (Endereco) entidade;
		String filtro = e.getRua();


		String sql = "FROM " + Endereco.class.getName(); 
		if(filtro!="") {
			sql =sql + " WHERE rua like :paramNome OR bairro like :paramNome "
					+ "OR cidade like :paramNome OR estado like :paramNome "
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
		return em.find(Endereco.class, id);
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		Endereco endereco = (Endereco) entidade;

		try {
			em.getTransaction().begin();
			em.merge(endereco);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	@SuppressWarnings("unchecked")
	public List<EntidadeDominio> findByIdCliente(int id_cliente) {
		
		String sql = "FROM " + Endereco.class.getName(); 
		sql =sql + " WHERE id_cliente = :paramNome"	;
		Query query = em.createQuery(sql);
		query.setParameter("paramNome", id_cliente);
		List<EntidadeDominio> entidades = query.getResultList();
		return entidades;
	}
	
	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
