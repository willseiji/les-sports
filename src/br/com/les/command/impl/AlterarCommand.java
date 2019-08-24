/**
 * 
 */
package br.com.les.command.impl;

import br.com.les.aplicacao.Resultado;
import br.com.les.command.ICommand;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.fachada.impl.Fachada;

/**
 * @author william
 *
 */
public class AlterarCommand implements ICommand {

	Fachada fachada = new Fachada();
	 Resultado resultado = new Resultado();
	 
	public Resultado executar(EntidadeDominio entidade) {
		
	     resultado = fachada.alterar(entidade);
	     return resultado;
	}


}
