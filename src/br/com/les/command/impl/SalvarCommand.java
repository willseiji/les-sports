package br.com.les.command.impl;

import java.sql.SQLException;

import br.com.les.aplicacao.Resultado;
import br.com.les.command.ICommand;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.fachada.impl.Fachada;

public class SalvarCommand implements ICommand {

	Fachada fachada = new Fachada();
	Resultado resultado = new Resultado();
	public Resultado executar(EntidadeDominio entidade) {
		try {
			resultado = fachada.salvar(entidade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return resultado;
	}


}
