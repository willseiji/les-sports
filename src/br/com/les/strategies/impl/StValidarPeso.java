package br.com.les.strategies.impl;

import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;
import br.com.les.strategies.IStrategy;

public class StValidarPeso implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Produto produto = (Produto) entidade;
        String msg="";
        if(produto.getPeso()<=0 )
        {
           msg = "Peso inválido. ";
        }
        return msg;
	}


}
