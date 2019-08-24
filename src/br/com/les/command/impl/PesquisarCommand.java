package br.com.les.command.impl;

import java.util.List;

import br.com.les.aplicacao.Resultado;
import br.com.les.command.ICommand;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.fachada.impl.Fachada;

public class PesquisarCommand implements ICommand {

	Fachada fachada = new Fachada();
	 Resultado resultado = new Resultado();
	 List<EntidadeDominio> listEntidade = new java.util.ArrayList<EntidadeDominio>();
	   
	    
	public Resultado executar(EntidadeDominio entidade) {
		resultado = fachada.pesquisar(entidade);
		return resultado;
	}

}
