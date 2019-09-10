package br.com.les.viewhelper.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.les.aplicacao.Resultado;
import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dominio.impl.Carrinho;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Item;
import br.com.les.dominio.impl.Pedido;
import br.com.les.dominio.impl.Produto;
import br.com.les.servico.impl.ClienteServico;
import br.com.les.viewhelper.IViewHelper;

public class MenuCartViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ClienteServico servicoCliente = new ClienteServico();
		ProdutoDAO daoProduto = new ProdutoDAO();
		Pedido pedido = new Pedido();
		
		int id_cliente = (int) session.getAttribute("idCliente");
		
		Cliente clienteDTO = new Cliente();
		clienteDTO.setId(id_cliente);
		EntidadeDominio entidadeDTO = (EntidadeDominio) clienteDTO;
		
		List<EntidadeDominio> entidadesClienteDTO = servicoCliente.prealterar(entidadeDTO);
		Cliente clientePedido = (Cliente) entidadesClienteDTO.get(0);
		
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		
		String valorSubTotal = request.getParameter("txt_valorSubTotal");
		String valorFrete = request.getParameter("txt_valorFrete");
		String valorDesconto = request.getParameter("txt_valorDesconto");
		String valorTotal = request.getParameter("txt_valorTotal");
		System.out.println("valor total: "+valorTotal);
				
		pedido.setSubTotal(Double.parseDouble(valorSubTotal));
		pedido.setValorFrete(Double.parseDouble(valorFrete));
		pedido.setValorDesconto(Double.parseDouble(valorDesconto));
		pedido.setValorTotal(Double.parseDouble(valorTotal));
		pedido.setCliente(clientePedido);
		pedido.setItens(carrinho.getItens());
		
		session.setAttribute("pedido",pedido);
		
		return pedido;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		List<String> itensCliente = new ArrayList<>();
		List<String> itensEndereco = new ArrayList<>(); ;
		List<String> itensItens = new ArrayList<>(); ;
		List<String> itensValor = new ArrayList<>(); ;
		List<List<String>> listaEnderecos = new java.util.ArrayList<List<String>>();
		List<List<String>> listaItens = new java.util.ArrayList<List<String>>();
		
		System.out.println("==================================");
		System.out.println("=====SET VIEW =============");
		
		System.out.println("tamanho de entidades: "+resultado.getEntidades().size());
		Pedido pedido= (Pedido) resultado.getEntidades().get(0);
		
		//-------------CLIENTE ------------------
		Cliente cliente = pedido.getCliente();
		itensCliente.add(Integer.toString(cliente.getId()));
		itensCliente.add(cliente.getNome());
		itensCliente.add(cliente.getSexo());
		itensCliente.add(cliente.getDtNasc());
		itensCliente.add(cliente.getRg());
		itensCliente.add(cliente.getCpf());		
		itensCliente.add(cliente.getEmail());
		itensCliente.add(cliente.getTelefone());
		
		System.out.println("----------CLIENTE--------------");
		for(int i=0;i<itensCliente.size();i++) {
			System.out.println(i + " : "+itensCliente.get(i));
		}
		
		for (int i = 0; i < cliente.getEnderecos().size(); i++) {
			Endereco endereco = cliente.getEnderecos().get(i);
			
        	itensEndereco = new java.util.ArrayList<String>();
        	itensEndereco.add(Integer.toString(endereco.getId()));
        	itensEndereco.add(endereco.getRua());
            itensEndereco.add(endereco.getNumero());
            itensEndereco.add(endereco.getComplemento());
            itensEndereco.add(endereco.getBairro());
            itensEndereco.add(endereco.getCep());
            itensEndereco.add(endereco.getCidade().getNome());
            itensEndereco.add(endereco.getCidade().getEstado().getNome());
            itensEndereco.add(endereco.getTipoEndereco());
            
            listaEnderecos.add(itensEndereco);
        }//for

		System.out.println("----------ENDERECOS-------------");
		for(int i=0;i<listaEnderecos.size();i++) {
			System.out.println("endereco: "+i);
			for(int j=0;j<listaEnderecos.get(i).size();j++) {
				System.out.println(j + " : "+listaEnderecos.get(i).get(j));
			}
		}
		
		//---------------------ITENS--------------------
		List<Item> itens = pedido.getItens();
		for (int i = 0; i < itens.size(); i++) {
			Item item = new Item();
			item = itens.get(i);
			Produto produto = item.getProduto();
			
        	itensItens = new java.util.ArrayList<String>();
        	itensItens.add(Integer.toString(item.getId()));
        	itensItens.add(produto.getCodigoProd());
        	itensItens.add(produto.getNome());
        	itensItens.add(produto.getFabricante());
            itensItens.add(produto.getMaterial());
            itensItens.add(produto.getTamanho());
            itensItens.add(Double.toString(produto.getPeso()));
            itensItens.add(Integer.toString((item.getQtde())));
            itensItens.add(Double.toString(produto.getPreco()));
        	itensItens.add(Double.toString(item.getSubTotal()));
            
        	
            itensItens.add(Integer.toString(produto.getQuantidade()));
            itensItens.add(produto.getCategoria());
            itensItens.add(produto.getStatus());
            
            listaItens.add(itensItens);
        }//for
		
		
		System.out.println("----------ITENS-------------");
		for(int i=0;i<listaItens.size();i++) {
			System.out.println("item: "+i);
			for(int j=0;j<listaItens.get(i).size();j++) {
				System.out.println(j + " : "+listaItens.get(i).get(j));
			}
		}
		
		
		itensValor.add(Double.toString(pedido.getSubTotal()));
		itensValor.add(Double.toString(pedido.getValorFrete()));
		itensValor.add(Double.toString(pedido.getValorDesconto()));
		itensValor.add(Double.toString(pedido.getValorTotal()));
		
		
		
		System.out.println("----------VALOR--------------");
		for(int i=0;i<itensValor.size();i++) {
			System.out.println(i + " : "+itensValor.get(i));
		}
		
		
		
		
		session.setAttribute("itensCliente",itensCliente);
		session.setAttribute("listaEnderecos",listaEnderecos);
		session.setAttribute("listaItens",listaItens);
		session.setAttribute("itensValor",itensValor);
		
		
		
		try {
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		} catch (ServletException ex) {
			Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
		

	}

}
