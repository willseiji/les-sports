package br.com.les.servico;

import java.sql.SQLException;
import java.util.List;

import br.com.les.dominio.impl.EntidadeDominio;

public interface IServico {
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException;
	 public List<EntidadeDominio> alterar(EntidadeDominio entidade);
	 public List<EntidadeDominio> prealterar(EntidadeDominio entidade);
	 public List<EntidadeDominio> pesquisar(EntidadeDominio entidade);
	 public List<EntidadeDominio> excluir(EntidadeDominio entidade) ;
}
