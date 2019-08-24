package br.com.les.command;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.EntidadeDominio;

public interface ICommand {
	public Resultado executar(EntidadeDominio entidade);
}
