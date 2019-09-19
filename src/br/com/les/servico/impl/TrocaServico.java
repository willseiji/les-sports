package br.com.les.servico.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.impl.CartaoDAO;
import br.com.les.dao.impl.ClienteDAO;
import br.com.les.dao.impl.EnderecoDAO;
import br.com.les.dao.impl.FormaPagamentoDAO;
import br.com.les.dao.impl.ItemDAO;
import br.com.les.dao.impl.ItemTrocaDAO;
import br.com.les.dao.impl.ItensCartaoDAO;
import br.com.les.dao.impl.PedidoDAO;
import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dao.impl.TrocaDAO;
import br.com.les.dominio.impl.CartaoCredito;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.FormaPagamento;
import br.com.les.dominio.impl.Item;
import br.com.les.dominio.impl.ItemTroca;
import br.com.les.dominio.impl.ItensCartao;
import br.com.les.dominio.impl.Pedido;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Troca;
import br.com.les.servico.IServico;
import br.com.les.strategies.IStrategy;
import br.com.les.strategies.impl.StRetornarEstoque;

public class TrocaServico implements IServico {

	TrocaDAO daoTroca = new TrocaDAO();
	ItemTrocaDAO daoItemTroca = new ItemTrocaDAO();
	ProdutoDAO daoProduto = new ProdutoDAO();
	ClienteDAO daoCliente = new ClienteDAO();
	
	@Override
	public List<EntidadeDominio> salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		Troca troca = (Troca) entidade;
		
		
		//---------------gravacao de troca----------------
	
		Troca trocaSalvo = (Troca) daoTroca.salvar(troca);
		trocaSalvo.setData(trocaSalvo.getData_super());
		
		String codigo = geradorCodigo(trocaSalvo.getId());
		trocaSalvo.setCodigo(codigo);
		
		daoTroca.alterar(trocaSalvo);
		
		int id_troca = trocaSalvo.getId();
		
		
		//------------------gravacao de itensTroca---------------------
		System.out.println("------------------------------");
		
		System.out.println("tamanho de itens de troca: "+troca.getItensTroca().size());
		for(int i=0;i<troca.getItensTroca().size();i++) {
			
			ItemTroca itemTrocaDTO = new ItemTroca();
			EntidadeDominio entidadeItemTrocaDTO = new EntidadeDominio();
			itemTrocaDTO = troca.getItensTroca().get(i);
			itemTrocaDTO.setId_troca(id_troca);
			System.out.println("--------------DTO------------");
			System.out.println("item de Troca "+i+" - qtde Trocada: " +itemTrocaDTO.getQtdeTrocada());
			System.out.println("item de Troca "+i+" - preco: " +itemTrocaDTO.getPreco());
			System.out.println("item de Troca "+i+" - valor troca: " +itemTrocaDTO.valorTroca());
			
			entidadeItemTrocaDTO = daoItemTroca.salvar(itemTrocaDTO);
			
		
		
		}
		
				
		return null;
	}

	@Override
	public List<EntidadeDominio> alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Troca troca = (Troca) entidade;
		int id_troca=troca.getId();
		
		System.out.println("em prealterar 1");
		Troca trocaDTO = (Troca) daoTroca.prealterar(id_troca);
		trocaDTO.setStatus(troca.getStatus());
		System.out.println("em prealterar ");
		daoTroca.alterar(trocaDTO);
		List<EntidadeDominio> entidades = daoItemTroca.findByIdTroca(id_troca);
		
		System.out.println("tamanho entidades: "+entidades.size());
		for(int i=0;i<entidades.size();i++) {
			System.out.println("i: "+i);
			ItemTroca itemTrocaDTO = new ItemTroca();
			itemTrocaDTO = (ItemTroca) entidades.get(i);
			System.out.println("itemTrocaDTO: "+itemTrocaDTO);
			System.out.println("status: "+troca.getStatus());
			if("TROCA APROVADA".equals(troca.getStatus())) {
				System.out.println("troca aprovada");
				StRetornarEstoque vRetornarEstoque= new StRetornarEstoque();
				vRetornarEstoque.processar(itemTrocaDTO);
			}
		
		}
		
		
		
		
		
		return null;
	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		//--------------leitura de pedido-------------
		System.out.println("--------------leitura de troca-------------");
		Troca troca = (Troca) entidade;
		int id_troca = troca.getId();
		Troca trocaDTO = new Troca();
		trocaDTO = (Troca) daoTroca.prealterar(id_troca);
		
		
		//-----------------leitura de itens---------------
		System.out.println("-----------------leitura de itens---------------");
		
		List<EntidadeDominio> entidadesItens = new ArrayList<>();
		entidadesItens = daoItemTroca.findByIdTroca(id_troca);
		List<EntidadeDominio> entidadesDTO = new ArrayList<>();
		List<ItemTroca> itensTrocaDTO = new ArrayList<>();
		ItemTroca itemTrocaDTO = new ItemTroca();
		for(int j=0;j<entidadesItens.size();j++) {
			itemTrocaDTO = (ItemTroca) entidadesItens.get(j);
			Produto produtoDTO = new Produto();
			produtoDTO = (Produto) daoProduto.prealterar(itemTrocaDTO.getId_produto());
			System.out.println("produtoDTO: "+produtoDTO);
			
			itemTrocaDTO.setProduto(produtoDTO);
		
			itensTrocaDTO.add(itemTrocaDTO);
			
		}
		trocaDTO.setItensTroca(itensTrocaDTO);
		EntidadeDominio entidadeDTO = (EntidadeDominio) trocaDTO;
		entidadesDTO.add(entidadeDTO);
		return entidadesDTO;
		
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		List<EntidadeDominio> entidadesTroca = new ArrayList<>();
		entidadesTroca = daoTroca.pesquisar(entidade);
		List<EntidadeDominio> entidadesDTO = new ArrayList<>();
		
		for(int i=0;i<entidadesTroca.size();i++) {
			Troca trocaDTO = (Troca) entidadesTroca.get(i);
			int id_cliente = trocaDTO.getId_cliente();
			
			
			Cliente cliente = (Cliente) daoCliente.prealterar(id_cliente);
			trocaDTO.setCliente(cliente);
		
			int id_troca = trocaDTO.getId();
			
			
			List<EntidadeDominio> entidadesItensDTO = daoItemTroca.findByIdTroca(id_troca);
			List<ItemTroca> itensTrocaDTO = new ArrayList<>();
			
			for(int j=0;j<entidadesItensDTO.size();j++) {
				ItemTroca itemTrocaDTO = (ItemTroca) entidadesItensDTO.get(j);
				System.out.println("id_produto: "+itemTrocaDTO.getId_produto());
				Produto produtoDTO = new Produto(); 
				produtoDTO = (Produto) daoProduto.prealterar(itemTrocaDTO.getId_produto());
				itemTrocaDTO.setProduto(produtoDTO);
				itensTrocaDTO.add(itemTrocaDTO);
			}
			
			trocaDTO.setItensTroca(itensTrocaDTO);
			
			EntidadeDominio entidadeDTO = (EntidadeDominio) trocaDTO;
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
        String code = "TRC"+stValorId;
		//String code = stValorId;
        System.out.println("codigo gerado: "+code);
        return code;
	}



}
