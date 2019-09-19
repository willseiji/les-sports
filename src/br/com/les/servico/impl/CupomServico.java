package br.com.les.servico.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.ConnectionFactory;
import br.com.les.dao.impl.CupomDAO;
import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dominio.impl.Cupom;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;
import br.com.les.servico.IServico;
import br.com.les.strategies.impl.StRetornarEstoque;

public class CupomServico implements IServico {

	CupomDAO daoCupom = new CupomDAO();
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		Cupom cupom = (Cupom) daoCupom.salvar(entidade);
		cupom.setData(cupom.getData_super());
	
		String codigo = geradorCodigo(cupom.getId());
		cupom.setCodigo(codigo);
		entidade = (EntidadeDominio) cupom;
		
		daoCupom.alterar(entidade);
	
		List<EntidadeDominio> entidades = new ArrayList<>();
		entidades.add(entidade);
		return entidades;

	}

	@Override
	public List<EntidadeDominio> alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		daoCupom.alterar(entidade);
		return null;
	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Cupom cupom = (Cupom) entidade;
		List<EntidadeDominio> cupons = new ArrayList<>();
		
		int id_cupom = cupom.getId();
		
		Cupom cup = (Cupom) daoCupom.prealterar(id_cupom);
		cupons.add(cup); 
		return cupons;
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return daoCupom.pesquisar(entidade);
	}

	@Override
	public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		daoCupom.excluir(entidade);
		return null;

	}
	
	public String geradorCodigo(int id) {
		System.out.println("inicio de codigo: "+id);
		String stValorId = String.format("%05d",id);
		System.out.println("inicio de codigo");
		//String initCateg = nome.substring(0, 3);
        String code = "CUP"+stValorId;
		//String code = stValorId;
        System.out.println("codigo gerado: "+code);
        return code;
	}


}
