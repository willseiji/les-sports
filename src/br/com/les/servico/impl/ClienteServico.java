package br.com.les.servico.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.impl.ClienteDAO;
import br.com.les.dao.impl.EnderecoDAO;
import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dao.impl.UsuarioDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Usuario;
import br.com.les.servico.IServico;

public class ClienteServico implements IServico {

	ClienteDAO daoCliente = new ClienteDAO();
	EnderecoDAO daoEndereco = new EnderecoDAO();
	UsuarioDAO daoUsuario = new UsuarioDAO();
	Cliente cliente;
	Endereco endereco;
	
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		
		System.out.println("servico dao endereco");
		cliente = (Cliente) entidade;
		
		endereco = cliente.getEnderecos().get(0);
		entidade = (EntidadeDominio) endereco;
		
		int id_endereco = daoEndereco.salvar(entidade);
		
		System.out.println("fora de dao endereco");
		System.out.println("id_Endereco: "+id_endereco);
		
		cliente.getEnderecos().get(0).setId(id_endereco);
//		endereco.setId(id_endereco);
		entidade = (EntidadeDominio) cliente;
		
		int id_cliente = daoCliente.salvar(entidade);
		System.out.println("fora de dao cliente");
		System.out.println("id_cliente: "+id_cliente);
		
		Usuario u = new Usuario();
		u.setNome(cliente.getUsuario().getNome());
		u.setSenha(cliente.getUsuario().getSenha());
		u.setId_cliente(id_cliente);
		//entidade = (EntidadeDominio) u;
		int id_usuario = daoUsuario.salvar(u);
		
		
		return null;

	}

	@Override
	public List<EntidadeDominio> alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		
		List<Endereco> enderecos = new ArrayList<>();
		endereco = new Endereco();
		List<EntidadeDominio> ents = daoCliente.prealterar(entidade);
		/*cliente = (Cliente) entidade;
		System.out.println("===========+++============");
		System.out.println("size: "+cliente.getEnderecos().size());
		for(int i=0;i<cliente.getEnderecos().size();i++) {
			System.out.println("id endereco: "+cliente.getEnderecos().get(i).getId());
			endereco = (Endereco) daoEndereco.prealterar(cliente.getEnderecos().get(i));
			enderecos.add(endereco);
		}
		cliente.setEnderecos(enderecos);*/
		EntidadeDominio ent = (EntidadeDominio) cliente;
		
		//List<EntidadeDominio> ents = new ArrayList<EntidadeDominio>();
		//ents.add(ent);
		return ents;	
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return daoCliente.pesquisar(entidade);
	}

	@Override
	public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
