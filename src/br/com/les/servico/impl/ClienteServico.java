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
		
		cliente = (Cliente) entidade;
		
		endereco = cliente.getEnderecos().get(0);
		entidade = (EntidadeDominio) endereco;
		
		int id_endereco = daoEndereco.salvar(entidade);
		
		cliente.getEnderecos().get(0).setId(id_endereco);
//		endereco.setId(id_endereco);
		entidade = (EntidadeDominio) cliente;
		
		int id_cliente = daoCliente.salvar(entidade);
		
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
		Endereco end = new Endereco();
		
		
		List<EntidadeDominio> ents = daoCliente.prealterar(entidade);
		
		cliente = (Cliente) ents.get(0);
		
		System.out.println("===========+++============");
		/*System.out.println("cliente: "+cliente);
		System.out.println("enderecos: "+cliente.getEnderecos());
		System.out.println("size: "+cliente.getEnderecos().size());
		System.out.println("===========+++============");
		*/
		
		for(int i=0;i<ents.size();i++) {
			cliente = (Cliente) ents.get(i);
			System.out.println("size no servico: "+cliente.getEnderecos().size());
			//if(cliente.getEnderecos().size()!=0) {	
			for(int j=0;j<cliente.getEnderecos().size();j++) {
				endereco = cliente.getEnderecos().get(j);
				Endereco ender = new Endereco();
				EntidadeDominio ent2 = new EntidadeDominio();
				
				System.out.println("id endereco: "+endereco.getId());
				int id_endereco = endereco.getId();
				Endereco enderecoDTO = new Endereco();
				enderecoDTO.setId(id_endereco);
				ent2 = (EntidadeDominio) enderecoDTO;
				
				
				ents = daoEndereco.prealterar(ent2);
				if(ents.size()>0) {
					System.out.println("size no servico apos prealterar: "+ents.size());
					ender = (Endereco) ents.get(0);
					System.out.println("ender no servico apos prealterar: "+ender.getRua());
				}
				else {
					ender=null;
				}
				
				
				enderecos.add(ender);
			}
			cliente.setEnderecos(enderecos);
			//}
		}
		
		EntidadeDominio ent = (EntidadeDominio) cliente;
		
		List<EntidadeDominio> entidades = new ArrayList<>();
		
		entidades.add(ent);
		return entidades;	
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
