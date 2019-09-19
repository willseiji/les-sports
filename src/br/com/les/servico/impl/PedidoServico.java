package br.com.les.servico.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.impl.CartaoDAO;
import br.com.les.dao.impl.ClienteDAO;
import br.com.les.dao.impl.EnderecoDAO;
import br.com.les.dao.impl.FormaPagamentoDAO;
import br.com.les.dao.impl.ItemDAO;
import br.com.les.dao.impl.ItensCartaoDAO;
import br.com.les.dao.impl.PedidoDAO;
import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dominio.impl.CartaoCredito;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.FormaPagamento;
import br.com.les.dominio.impl.Item;
import br.com.les.dominio.impl.ItensCartao;
import br.com.les.dominio.impl.Pedido;
import br.com.les.dominio.impl.Produto;
import br.com.les.servico.IServico;
import br.com.les.strategies.impl.StDarBaixaEstoque;
import br.com.les.strategies.impl.StRetornarEstoque;

public class PedidoServico implements IServico {

	PedidoDAO daoPedido = new PedidoDAO();
	ItemDAO daoItem = new ItemDAO();
	ClienteDAO daoCliente = new ClienteDAO();
	EnderecoDAO daoEndereco = new EnderecoDAO();
	ProdutoDAO daoProduto = new ProdutoDAO();
	CartaoDAO daoCartao = new CartaoDAO();
	FormaPagamentoDAO daoFormaPgto = new FormaPagamentoDAO();
	ItensCartaoDAO daoItensCartao = new ItensCartaoDAO();
	
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		Pedido pedido = (Pedido) entidade;
		
		//---------------gravacao de pedido----------------
		int id_cliente = pedido.getCliente().getId();
		pedido.setId_cliente(id_cliente);
		
		Pedido pedidoSalvo = (Pedido) daoPedido.salvar(pedido);
		pedidoSalvo.setData(pedidoSalvo.getData_super());
		
		
		String codigo = geradorCodigo(pedidoSalvo.getId());
		pedidoSalvo.setCodigo(codigo);
		
		daoPedido.alterar(pedidoSalvo);
		
		int id_pedido = pedidoSalvo.getId();
		
		System.out.println("id_pedido : " + pedidoSalvo.getId());
		System.out.println("pedido subtotal: "+pedidoSalvo.getSubTotal());
		System.out.println("pedido frete: "+pedidoSalvo.getValorFrete());
		System.out.println("pedido desconto: "+pedidoSalvo.getValorDesconto());
		System.out.println("pedido total: "+pedidoSalvo.getValorTotal());
		System.out.println("pedido cliente: "+pedidoSalvo.getCliente().getNome());
		
		//------------------gravacao de itens---------------------
		System.out.println("------------------------------");
		for(int i=0;i<pedidoSalvo.getItens().size();i++) {
			
			Item itemDTO = new Item();
			EntidadeDominio entidadeItemDTO = new EntidadeDominio();
			itemDTO = pedido.getItens().get(i);
			System.out.println("produto: "+itemDTO.getProduto().getNome());
			System.out.println("qtde: "+itemDTO.getQtde());
			System.out.println("id_pedido dentro de laço: " + id_pedido);
			itemDTO.setId_pedido(id_pedido);
			itemDTO.setId_produto(itemDTO.getProduto().getId());
			
			entidadeItemDTO = daoItem.salvar(itemDTO);		
			
			StDarBaixaEstoque vDarBaixaEstoque= new StDarBaixaEstoque();
			vDarBaixaEstoque.processar(itemDTO);
		}
		
		//-----------------gravacao pagamento--------------------
		FormaPagamento formaPgto = pedido.getPagamento().getFormaPgto();
		formaPgto.setId_pedido(id_pedido);
		EntidadeDominio entidadeFormaSalvo = daoFormaPgto.salvar(formaPgto);
		FormaPagamento pgtoSalvo = (FormaPagamento) entidadeFormaSalvo;
		
		int id_pagamento = pgtoSalvo.getId();
		
		System.out.println("tamanho de cartoes: "+formaPgto.getItensCartao().size());
		System.out.println(" cartoes: "+formaPgto.getItensCartao());
		for(int i=0;i<formaPgto.getItensCartao().size();i++) {
			ItensCartao itemCartaoDTO = new ItensCartao();
			EntidadeDominio entidadeItensCartaoDTO = new EntidadeDominio();
			itemCartaoDTO = formaPgto.getItensCartao().get(i);
			System.out.println("itemCartao: "+itemCartaoDTO);
			
			itemCartaoDTO.setId_pagamento(id_pagamento);
			EntidadeDominio entidadeItensSalvoSalvo = daoItensCartao.salvar(itemCartaoDTO);
		}
			
		
		return null;
	}

	@Override
	public List<EntidadeDominio> alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Pedido pedido = (Pedido) entidade;
		int id_pedido=pedido.getId();
		System.out.println("id_pedido: "+id_pedido);
		System.out.println("Status: "+pedido.getStatus());
		
		Pedido pedidoDTO = (Pedido) daoPedido.prealterar(id_pedido);
		pedidoDTO.setStatus(pedido.getStatus());
		
		daoPedido.alterar(pedidoDTO);
		
		
		return null;
	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		//--------------leitura de pedido-------------
		System.out.println("--------------leitura de pedido-------------");
		Pedido pedido = (Pedido) entidade;
		int id_pedido = pedido.getId();
		Pedido pedidoDTO = new Pedido();
		pedidoDTO = (Pedido) daoPedido.prealterar(id_pedido);
		System.out.println("pedido DEPOIS Status na DAO Prealterar: "+pedidoDTO.getStatus());
		
		//--------------leitura de cliente
		System.out.println("--------------leitura de cliente-----------");
		int id_cliente = pedidoDTO.getId_cliente();
		Cliente clienteDTO = new Cliente();
		clienteDTO = (Cliente) daoCliente.prealterar(id_cliente);
		
		//-------------leitura de endereco---------------------
		System.out.println("-------------leitura de endereco---------------------");
		List<EntidadeDominio> entidadesEnderecos = daoEndereco.findByIdCliente(id_cliente);
		
		List<Endereco> enderecosDTO = new ArrayList<>();
		Endereco enderecoDTO = new Endereco();
		for(int j=0;j<entidadesEnderecos.size();j++) {
			enderecoDTO = (Endereco) entidadesEnderecos.get(j);
			enderecosDTO.add(enderecoDTO);
		}
		clienteDTO.setEnderecos(enderecosDTO);
		
		
		//------------------leitura de cartoes-------------------
		System.out.println("------------------leitura de cartoes-------------------");
		List<EntidadeDominio> entidadesCartoes = daoCartao.findByIdCliente(id_cliente);
		
		List<CartaoCredito> cartoesDTO = new ArrayList<>();
		CartaoCredito cartaoDTO = new CartaoCredito();
		for(int j=0;j<entidadesCartoes.size();j++) {
			cartaoDTO = (CartaoCredito) entidadesCartoes.get(j);
			cartoesDTO.add(cartaoDTO);
		}
		clienteDTO.setCartoes(cartoesDTO);
		
		//-----------------leitura de itens---------------
		System.out.println("-----------------leitura de itens---------------");
		pedidoDTO.setCliente(clienteDTO);
		
		List<EntidadeDominio> entidadesItens = new ArrayList<>();
		entidadesItens = daoItem.findByIdPedido(id_pedido);
		List<EntidadeDominio> entidadesDTO = new ArrayList<>();
		List<Item> itensDTO = new ArrayList<>();
		Item itemDTO = new Item();
		for(int j=0;j<entidadesItens.size();j++) {
			itemDTO = (Item) entidadesItens.get(j);
			System.out.println("*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("id_produto: "+itemDTO.getId_produto());
			Produto produtoDTO = new Produto();
			produtoDTO = (Produto) daoProduto.prealterar(itemDTO.getId_produto());
			System.out.println("produtoDTO: "+produtoDTO);
			
			itemDTO.setProduto(produtoDTO);
		
			itensDTO.add(itemDTO);
			
		}
		pedidoDTO.setItens(itensDTO);
		EntidadeDominio entidadeDTO = (EntidadeDominio) pedidoDTO;
		entidadesDTO.add(entidadeDTO);
		return entidadesDTO;
		
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		List<EntidadeDominio> entidadesPedidos = new ArrayList<>();
		entidadesPedidos = daoPedido.pesquisar(entidade);
		List<EntidadeDominio> entidadesDTO = new ArrayList<>();
		
		for(int i=0;i<entidadesPedidos.size();i++) {
			Pedido pedidoDTO = (Pedido) entidadesPedidos.get(i);
			int id_cliente = pedidoDTO.getId_cliente();
			
			System.out.println("pedido Status na DAO: "+pedidoDTO.getStatus());
			
			Cliente cliente = (Cliente) daoCliente.prealterar(id_cliente);
			pedidoDTO.setCliente(cliente);
		
			int id_pedido = pedidoDTO.getId();
			
			
			List<EntidadeDominio> entidadesItensDTO = daoItem.findByIdPedido(id_pedido);
			List<Item> itensDTO = new ArrayList<>();
			
			for(int j=0;j<entidadesItensDTO.size();j++) {
				Item itemDTO = (Item) entidadesItensDTO.get(j);
				System.out.println("id_produto: "+itemDTO.getId_produto());
				Produto produtoDTO = new Produto(); 
				produtoDTO = (Produto) daoProduto.prealterar(itemDTO.getId_produto());
				itemDTO.setProduto(produtoDTO);
				itensDTO.add(itemDTO);
			}
			
			pedidoDTO.setItens(itensDTO);
			
			EntidadeDominio entidadeDTO = (EntidadeDominio) pedidoDTO;
			entidadesDTO.add(entidadeDTO);
		}
		
		return entidadesDTO;

	}

	@Override
	public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String geradorCodigo(int id) {
		System.out.println("inicio de codigo: "+id);
		String stValorId = String.format("%05d",id);
		System.out.println("inicio de codigo");
		//String initCateg = nome.substring(0, 3);
        String code = "AAA"+stValorId;
		//String code = stValorId;
        System.out.println("codigo gerado: "+code);
        return code;
	}



}
