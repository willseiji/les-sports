package br.com.les.strategies.impl;

import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.strategies.IStrategy;

public class StDadosCEPCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
	    String msg = "";
	    if(cliente.getEnderecos().get(0).getCep()!=null) {
		    if(cliente.getEnderecos().get(0).getCep().length()!=8) {
		    	msg = "CEP invalido. ";
		    }
	    }
	    return msg;
	}

}
