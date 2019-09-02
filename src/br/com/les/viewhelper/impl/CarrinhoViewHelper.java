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
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Item;
import br.com.les.dominio.impl.Produto;
import br.com.les.viewhelper.IViewHelper;

public class CarrinhoViewHelper implements IViewHelper {

	Carrinho carrinho = new Carrinho();
	EntidadeDominio entidade = new EntidadeDominio();
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operacao = request.getParameter("operacao");
		if (operacao.equals("SALVAR")  ){
	
			HttpSession session = request.getSession();
			ProdutoDAO daoProduto = new ProdutoDAO();
			
			Item item = new Item();
			
			
			int idProduto = (int) Integer.parseInt(request.getParameter("txt_IdProduto"));
			 String qtdeItens = (String) request.getParameter("txt_Itens");
			 String subTotal = (String) request.getParameter("txt_PrecoTotal");
			
			 System.out.println("--------------------------------");
			 System.out.println("idProduto: "+idProduto);
			 System.out.println("qtdeItens vindo do carrinho: "+qtdeItens);
			 System.out.println("subtotal vindo do carrinho: "+subTotal);
			 
			Produto produto = (Produto) daoProduto.prealterar(idProduto);
			
			carrinho = (Carrinho) session.getAttribute("carrinho");
			
			List<Item> itens;
			
			if(carrinho == null)
			{
				carrinho = new Carrinho();
				itens = new ArrayList<>();
						
			}else {
				itens =carrinho.getItens();
			}
			
			System.out.println("tamanho de itens: "+itens.size());
			item.setQtde(Integer.parseInt(qtdeItens));
			item.setSubTotal(Integer.parseInt(subTotal));
			item.setProduto(produto);
			itens.add(item);
			carrinho.setItens(itens);
			carrinho.setPrecoTotal(1050);
			session.setAttribute("carrinho",carrinho);
			
			System.out.println("carrinho: "+carrinho);
			System.out.println("itens: "+itens.size());
			int i = itens.size()-1;
			System.out.println("id_produto: "+carrinho.getItens().get(i).getProduto().getId());
			System.out.println("qtdeItens: "+carrinho.getItens().get(i).getQtde());
			System.out.println("subTotal: "+carrinho.getItens().get(i).getSubTotal());
			System.out.println("nome_produto: "+carrinho.getItens().get(i).getProduto().getNome());
			System.out.println("codigo_produto: "+carrinho.getItens().get(i).getProduto().getCodigoProd());
			System.out.println("precoTotal: "+carrinho.getPrecoTotal());
			
			entidade = (EntidadeDominio) carrinho;
			
		}
		
		
		return entidade;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operacao = request.getParameter("operacao");
		
		if (operacao.equals("SALVAR")  ){
			
			HttpSession session = request.getSession();
			List<String> itensCarrinho ;
			List<List<String>> listaCarrinho = new java.util.ArrayList<List<String>>();
			
			System.out.println("==================================");
			System.out.println("=====SET VIEW =============");
			
			
			System.out.println("tamanho de entidades: "+resultado.getEntidades().size());
			Carrinho carrinho = (Carrinho) resultado.getEntidades().get(0);
			List<Item> itens = carrinho.getItens();
			int k = itens.size()-1;
			System.out.println("carrinho: "+carrinho);
			System.out.println("precoTotal: "+carrinho.getPrecoTotal());
			System.out.println("itens: "+itens.size());
			System.out.println("id_produto: "+itens.get(k).getProduto().getId());
			System.out.println("qtdeItens: "+carrinho.getItens().get(k).getQtde());
			System.out.println("subTotal: "+carrinho.getItens().get(k).getSubTotal());
			System.out.println("nome_produto: "+carrinho.getItens().get(k).getProduto().getNome());
			System.out.println("codigo_produto: "+carrinho.getItens().get(k).getProduto().getCodigoProd());
			
			System.out.println("TAMANHO ITENS: "+itens.size());
			
			for(int i=0;i<itens.size();i++) {
				Item item = itens.get(i);
				Produto produto = item.getProduto();
				itensCarrinho = new ArrayList<>();
				/*
				itensCarrinho.add(Integer.toString(carrinho.getItens().get(i).getId()));
				itensCarrinho.add(Integer.toString(carrinho.getItens().get(i).getQtde()));
				itensCarrinho.add(Double.toString(carrinho.getItens().get(i).getSubTotal()));
				itensCarrinho.add(carrinho.getItens().get(i).getProduto().getCodigoProd());
				itensCarrinho.add(carrinho.getItens().get(i).getProduto().getNome());
				itensCarrinho.add(carrinho.getItens().get(i).getProduto().getFabricante());
				itensCarrinho.add(Double.toString(carrinho.getItens().get(i).getProduto().getPreco()));
				itensCarrinho.add(Integer.toString(carrinho.getItens().get(i).getProduto().getId()));
				*/
				itensCarrinho.add(Integer.toString(item.getId()));
				itensCarrinho.add(Integer.toString(item.getQtde()));
				itensCarrinho.add(Double.toString(item.getSubTotal()));
				itensCarrinho.add(produto.getCodigoProd());
				itensCarrinho.add(produto.getNome());
				itensCarrinho.add(produto.getFabricante());
				itensCarrinho.add(Double.toString(produto.getPreco()));
				itensCarrinho.add(Integer.toString(carrinho.getItens().get(i).getProduto().getId()));
				
				listaCarrinho.add(itensCarrinho);
			
			}
			if(session.getAttribute("listaCarrinho")!=null)
				session.removeAttribute("listaCarrinho");
			session.setAttribute("listaCarrinho",listaCarrinho);
			
			try {
				request.getRequestDispatcher("site-menu-carrinho.jsp").forward(request, response);
			} catch (ServletException ex) {
				Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			
		}
	

	}

}
