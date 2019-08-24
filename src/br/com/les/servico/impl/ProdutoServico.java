package br.com.les.servico.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.servico.IServico;

public class ProdutoServico implements IServico {

	ProdutoDAO dao = new ProdutoDAO();
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		int id = dao.salvar(entidade);
		return null;

	}

	@Override
	public List<EntidadeDominio> alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		dao.alterar(entidade);
		return null;
	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		
		return dao.prealterar(entidade);
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return dao.pesquisar(entidade);
	}

	@Override
	public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		dao.excluir(entidade);
		return null;

	}

}
