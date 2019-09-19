package br.com.les.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.les.dao.impl.ClienteDAO;
import br.com.les.dao.impl.PedidoDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Pedido;
import br.com.les.viewhelper.impl.ProdutoViewHelper;

/**
 * Servlet implementation class ServletMeusPedidos
 */
@WebServlet("/ServletMeusPedidos")
public class ServletMeusPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMeusPedidos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		
		HttpSession session = request.getSession();
		int id_cliente = (int) session.getAttribute("idCliente");

		Cliente cliente =  new Cliente();
		PedidoDAO daoPedido = new PedidoDAO();
		ClienteDAO daoCliente = new ClienteDAO();
		
		List<EntidadeDominio> entidades = daoPedido.findListByIdCliente(id_cliente);

		List<String> itensPedido;
		List<List<String>> listaPedidos = new java.util.ArrayList<List<String>>();
		for (int i = 0; i < entidades.size(); i++) {
			itensPedido = new java.util.ArrayList<String>();
			Pedido pedido = (Pedido) entidades.get(i);
			
			cliente = (Cliente) daoCliente.prealterar(id_cliente);

			System.out.println("------------------------");
			System.out.println("id_pedido: "+pedido.getId());
			System.out.println("codigo: "+pedido.getCodigo());
			System.out.println("nome: "+cliente.getNome());
			System.out.println("valor: "+pedido.getValorTotal());
			System.out.println("status: "+pedido.getStatus());

			itensPedido.add(Integer.toString(pedido.getId()));
			itensPedido.add(pedido.getCodigo());
			itensPedido.add(cliente.getNome());
			itensPedido.add(pedido.getData());
			itensPedido.add(Double.toString(pedido.getValorTotal()));
			itensPedido.add(pedido.getStatus());

			listaPedidos.add(itensPedido);
			
			
		}
		request.setAttribute("listaPedidos", listaPedidos);
		try {
			request.getRequestDispatcher("site-meus-pedidos.jsp").forward(request, response);
		} catch (ServletException ex) {
			Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
		}


		
	}

}
