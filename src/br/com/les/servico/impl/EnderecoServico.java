package br.com.les.servico.impl;

import java.sql.SQLException;
import java.util.List;

import br.com.les.dao.impl.EnderecoDAO;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.servico.IServico;

public class EnderecoServico implements IServico {

	EnderecoDAO daoEndereco = new EnderecoDAO();
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public List<EntidadeDominio> alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Endereco endereco = (Endereco) entidade;
		int id_endereco = endereco.getId();
		EnderecoDAO daoEndereco = new EnderecoDAO();
		Endereco enderecoDTO = (Endereco) daoEndereco.prealterar(id_endereco);
		int id_cliente = enderecoDTO.getId_cliente();
		List<EntidadeDominio> entidades = daoEndereco.findByIdCliente(id_cliente);
		for(int i=0;i<entidades.size();i++) {
			
			Endereco enderecoNovo = new Endereco();
			enderecoNovo = (Endereco) entidades.get(i);
			if(enderecoNovo.getId()!=id_endereco) {
				enderecoNovo.setPrincipal("NÃO");
			}else {
				enderecoNovo.setPrincipal("SIM");
			}
			daoEndereco.alterar(enderecoNovo);
			
		}
		
		
		
		return null;
	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		daoEndereco.excluir(entidade);
		return null ;
	}

}
