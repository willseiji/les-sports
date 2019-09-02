package br.com.les.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.les.dominio.impl.EntidadeDominio;

public interface IDAO {
	public EntidadeDominio salvar(EntidadeDominio entidade);
    public List<EntidadeDominio> pesquisar(EntidadeDominio entidade);
    public EntidadeDominio prealterar(int id);
    public void alterar(EntidadeDominio entidade);
    public void excluir(EntidadeDominio entidade) ;
    
    
}
