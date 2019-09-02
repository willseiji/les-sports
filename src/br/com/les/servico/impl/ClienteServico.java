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
import br.com.les.dominio.impl.Produto;
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
		
		Cliente cliente = (Cliente) entidade;
		EntidadeDominio entidadeDTO = new EntidadeDominio();
		
		entidadeDTO = daoCliente.salvar(entidade);
		Cliente clienteSalvo = (Cliente) entidadeDTO;
		
		String codigo = geradorCodigo(clienteSalvo.getNome(), clienteSalvo.getId());
		
		
		
		clienteSalvo.setCodigo(codigo);
		entidade = (EntidadeDominio) clienteSalvo;
		
		daoCliente.alterar(entidade);
		
		int id_cliente = clienteSalvo.getId();
		
		for(int i=0;i<cliente.getEnderecos().size();i++) {
			Endereco enderecoDTO = new Endereco();
			EntidadeDominio entidadeEnderecoDTO = new EntidadeDominio();
			enderecoDTO = cliente.getEnderecos().get(i);
			System.out.println("rua: "+enderecoDTO.getRua());
			System.out.println("bairro: "+enderecoDTO.getBairro());
			System.out.println("id_cliente dentro de laço: "+clienteSalvo.getId());
			enderecoDTO.setId_cliente(id_cliente);
			entidadeEnderecoDTO = (EntidadeDominio) enderecoDTO;
			entidadeEnderecoDTO = daoEndereco.salvar(entidadeEnderecoDTO);			
		}
		
		return null;

	}
	
	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		List<EntidadeDominio> entidadesClientes = daoCliente.pesquisar(entidade);
		List<EntidadeDominio> entidadesDTO = new ArrayList<>();
		
		for(int i=0;i<entidadesClientes.size();i++) {
			Cliente clienteDTO = (Cliente) entidadesClientes.get(i);
			int id_cliente = clienteDTO.getId();
			List<EntidadeDominio> entidadesEnderecosDTO = daoEndereco.findByIdCliente(id_cliente);
			List<Endereco> enderecosDTO = new ArrayList<>();
			for(int j=0;j<entidadesEnderecosDTO.size();j++) {
				Endereco enderecoDTO = (Endereco) entidadesEnderecosDTO.get(j);
				enderecosDTO.add(enderecoDTO);
			}
			clienteDTO.setEnderecos(enderecosDTO);
			EntidadeDominio entidadeDTO = (EntidadeDominio) clienteDTO;
			entidadesDTO.add(entidadeDTO);
		}
		
		return entidadesDTO;
	}



	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		
		System.out.println("entidade: "+entidade);
		Cliente cliente = (Cliente) entidade;
		System.out.println("cliente: "+cliente);
		int id_cliente = cliente.getId();
		System.out.println("id_cliente: "+id_cliente);
		Cliente clienteDTO = (Cliente) daoCliente.prealterar(id_cliente);
		System.out.println("clienteDTO: "+clienteDTO);
		List<EntidadeDominio> entidadesEnderecos = daoEndereco.findByIdCliente(id_cliente);
		System.out.println("entidadesEnderecos: "+entidadesEnderecos);
		
		List<EntidadeDominio> entidadesDTO = new ArrayList<>();
		List<Endereco> enderecosDTO = new ArrayList<>();
		Endereco enderecoDTO = new Endereco();
		for(int j=0;j<entidadesEnderecos.size();j++) {
			enderecoDTO = (Endereco) entidadesEnderecos.get(j);
			System.out.println("enderecoDTO: "+enderecoDTO);
			enderecosDTO.add(enderecoDTO);
			
		}
		System.out.println("enderecos: "+enderecosDTO);
		clienteDTO.setEnderecos(enderecosDTO);
		EntidadeDominio entidadeDTO = (EntidadeDominio) clienteDTO;
		entidadesDTO.add(entidadeDTO);
		return entidadesDTO;
		
		/*
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
		*/
		
	}

	@Override
	public List<EntidadeDominio> alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public String geradorCodigo(String nome, int id) {
		System.out.println("inicio de codigo");
		String stValorId = String.format("%05d",id);
		System.out.println("inicio de codigo");
		String initCateg = nome.substring(0, 3);
        String code = initCateg.toUpperCase()+stValorId;
        System.out.println("codigo gerado: "+code);
        return code;
	}



}
