package br.com.les.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
import br.com.les.viewhelper.impl.CarrinhoViewHelper;

/**
 * Servlet implementation class ServletCarrinho
 */
@WebServlet("/ServletCarrinho")
public class ServletCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CarrinhoViewHelper vh = new CarrinhoViewHelper();
		Carrinho carrinho = (Carrinho) vh.getEntidade(request);
		
		System.out.println("==================================");
		System.out.println("=====SERVLET=============");
		List<Item> itens = carrinho.getItens();
		System.out.println("carrinho: "+carrinho);
		System.out.println("precoTotal: "+carrinho.getPrecoTotal());
		System.out.println("itens: "+itens.size());
		int i = itens.size()-1;
		System.out.println("id_produto: "+carrinho.getItens().get(i).getProduto().getId());
		System.out.println("qtdeItens: "+carrinho.getItens().get(i).getQtde());
		System.out.println("subTotal: "+carrinho.getItens().get(i).getSubTotal());
		System.out.println("nome_produto: "+carrinho.getItens().get(i).getProduto().getNome());
		System.out.println("codigo_produto: "+carrinho.getItens().get(i).getProduto().getCodigoProd());
		
		
		Resultado resultado = new Resultado();
		EntidadeDominio entidade = (EntidadeDominio) carrinho;
		List<EntidadeDominio> entidades = new ArrayList<>();
		entidades.add(entidade);
		resultado.setEntidades(entidades);
		vh.setView(resultado, request, response);
		
				
	}

}
