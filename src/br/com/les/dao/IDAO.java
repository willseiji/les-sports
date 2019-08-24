package br.com.les.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.les.dominio.impl.EntidadeDominio;

public interface IDAO {
	public int salvar(EntidadeDominio entidade) throws SQLException;
    public List<EntidadeDominio> pesquisar(EntidadeDominio entidade);
    public List<EntidadeDominio> prealterar(EntidadeDominio entidade);
    public void alterar(EntidadeDominio entidade);
    public void excluir(EntidadeDominio entidade) ;
    
    
}
