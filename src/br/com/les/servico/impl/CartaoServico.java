package br.com.les.servico.impl;

import java.sql.SQLException;
import java.util.List;

import br.com.les.dao.impl.CartaoDAO;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.servico.IServico;

public class CartaoServico implements IServico {

	CartaoDAO daoCartao = new CartaoDAO();
	
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		EntidadeDominio entidadeSalvo = daoCartao.salvar(entidade);
		return null;
		
	}

	@Override
	public List<EntidadeDominio> alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
