package br.com.les.strategies.impl;

import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Item;
import br.com.les.dominio.impl.ItemTroca;
import br.com.les.dominio.impl.Produto;
import br.com.les.strategies.IStrategy;

public class StDarBaixaEstoque implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
			Item itemVenda = (Item) entidade;
			int qtde_vendida = itemVenda.getQtde();
			int id_produto = itemVenda.getId_produto();
			
			ProdutoDAO daoProduto = new ProdutoDAO();
			Produto produtoDTO = (Produto) daoProduto.prealterar(id_produto);
			int qtde_original = produtoDTO.getQuantidade();
			int qtde_atualizada = qtde_original-qtde_vendida;
			produtoDTO.setQuantidade(qtde_atualizada);
			daoProduto.alterar(produtoDTO);
		
		return null;
	}

}
