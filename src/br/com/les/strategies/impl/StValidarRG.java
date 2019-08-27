package br.com.les.strategies.impl;

import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.strategies.IStrategy;

public class StValidarRG implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
        String msg = "";
        	if(cliente.getRg().length()!=9 || cliente.getRg().length()!=8) {
            	msg = "Qtde de digitos do RG invalido. ";
            }
        return msg;
	}

}
