package br.com.les.servico.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.impl.CartaoDAO;
import br.com.les.dao.impl.ClienteDAO;
import br.com.les.dao.impl.EnderecoDAO;
import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dao.impl.UsuarioDAO;
import br.com.les.dominio.impl.CartaoCredito;
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
	CartaoDAO daoCartao = new CartaoDAO();
	Cliente cliente;
	Endereco endereco;
	CartaoCredito cartao;
	
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		
		
		
		Cliente cliente = (Cliente) entidade;
		
		Usuario usuario = cliente.getUsuario();
		EntidadeDominio entidadeUsuarioDTO = daoUsuario.salvar(usuario);
		Usuario usuarioDTO = (Usuario) entidadeUsuarioDTO;
		
		cliente.setId_usuario(usuario.getId());
		EntidadeDominio entidadeClienteDTO = daoCliente.salvar(cliente);
		Cliente clienteSalvo = (Cliente) entidadeClienteDTO;
		
		String codigo = geradorCodigo(clienteSalvo.getNome(), clienteSalvo.getId());
		clienteSalvo.setCodigo(codigo);
		daoCliente.alterar(clienteSalvo);
		
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
		
		List<EntidadeDominio> entidadesCartoes = daoCartao.findByIdCliente(id_cliente);
		System.out.println("entidadesCartoes: "+entidadesCartoes);
		
		List<EntidadeDominio> entidadesDTO = new ArrayList<>();
		List<Endereco> enderecosDTO = new ArrayList<>();
		Endereco enderecoDTO = new Endereco();
		for(int j=0;j<entidadesEnderecos.size();j++) {
			enderecoDTO = (Endereco) entidadesEnderecos.get(j);
			System.out.println("enderecoDTO: "+enderecoDTO);
			enderecosDTO.add(enderecoDTO);
		}
		clienteDTO.setEnderecos(enderecosDTO);
		
		List<CartaoCredito> cartoesDTO = new ArrayList<>();
		CartaoCredito cartaoDTO = new CartaoCredito();
		for(int j=0;j<entidadesCartoes.size();j++) {
			cartaoDTO = (CartaoCredito) entidadesCartoes.get(j);
			System.out.println("cartaoDTO: "+cartaoDTO);
			cartoesDTO.add(cartaoDTO);
		}
		System.out.println("cartoes: "+cartoesDTO);
		clienteDTO.setCartoes(cartoesDTO);
		
		
		EntidadeDominio entidadeDTO = (EntidadeDominio) clienteDTO;
		entidadesDTO.add(entidadeDTO);
		return entidadesDTO;
		
				
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
