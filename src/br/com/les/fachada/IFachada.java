package br.com.les.fachada;

import java.sql.SQLException;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.EntidadeDominio;

public interface IFachada {
	public Resultado salvar(EntidadeDominio entidade) throws SQLException;
	public Resultado pesquisar(EntidadeDominio entidade);
	public Resultado excluir(EntidadeDominio entidade);
	public Resultado prealterar(EntidadeDominio entidade);
    public Resultado alterar(EntidadeDominio entidade);
}
