package br.com.les.strategies.impl;

import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.strategies.IStrategy;

public class StValidarCPF implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente) entidade;
        String msg = "";
        	if(cliente.getCpf().length()!=11) {
            	msg = "Qtde de digitos do CPF invalido. ";
            }
        return msg;
	}
}
