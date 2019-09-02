package br.com.les.servico.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.ConnectionFactory;
import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;
import br.com.les.servico.IServico;

public class ProdutoServico implements IServico {

	ProdutoDAO dao = new ProdutoDAO();
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		Produto produto = (Produto) dao.salvar(entidade);
		
		String codigo = geradorCodigo(produto.getCategoria(), produto.getId());
		
		produto.setCodigoProd(codigo);
		entidade = (EntidadeDominio) produto;
		
		dao.alterar(entidade);
		
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
		Produto produto = (Produto) entidade;
		List<EntidadeDominio> produtos = new ArrayList<>();
		
		int id = produto.getId();
		
		Produto prod = 	(Produto) dao.prealterar(id);
		produtos.add(prod); 
		return produtos;
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
	
	public String geradorCodigo(String nome, int id) {
		
		String stValorId = String.format("%05d",id);
		String initCateg = nome.substring(0, 3);
        String code = initCateg.toUpperCase()+stValorId;
        return code;
	}


}
