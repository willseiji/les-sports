package br.com.les.command.impl;

import br.com.les.aplicacao.Resultado;
import br.com.les.command.ICommand;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.fachada.impl.Fachada;

public class PreAlterarCommand implements ICommand {

	 Fachada fachada = new Fachada();
	 Resultado resultado = new Resultado();
	    
	public Resultado executar(EntidadeDominio entidade) {
		System.out.println("prealterar");
		resultado = fachada.prealterar(entidade);
		return resultado;
	}

}
