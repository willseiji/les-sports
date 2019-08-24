package br.com.les.strategies;

import br.com.les.dominio.impl.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade);
}
