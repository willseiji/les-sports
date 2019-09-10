package br.com.les.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.Carrinho;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Pedido;
import br.com.les.viewhelper.impl.CarrinhoViewHelper;
import br.com.les.viewhelper.impl.MenuCartViewHelper;

/**
 * Servlet implementation class ServletPedido
 */
@WebServlet("/ServletCarrinhoPedido")
public class ServletMenuCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMenuCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MenuCartViewHelper vh = new MenuCartViewHelper();
		Pedido pedido = (Pedido) vh.getEntidade(request);
		
		Resultado resultado = new Resultado();
		EntidadeDominio entidade = (EntidadeDominio) pedido;
		List<EntidadeDominio> entidades = new ArrayList<>();
		entidades.add(entidade);
		resultado.setEntidades(entidades);
		vh.setView(resultado, request, response);
		
	}

}
