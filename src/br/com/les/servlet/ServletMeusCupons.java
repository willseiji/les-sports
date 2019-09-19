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
import br.com.les.dao.impl.CupomDAO;
import br.com.les.dao.impl.PedidoDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Cupom;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Pedido;
import br.com.les.viewhelper.impl.ProdutoViewHelper;

/**
 * Servlet implementation class ServletMeusPedidos
 */
@WebServlet("/ServletMeusCupons")
public class ServletMeusCupons extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMeusCupons() {
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

		Cupom cupom;
		CupomDAO daoCupom = new CupomDAO();
		
		List<EntidadeDominio> entidades = daoCupom.findListByIdCliente(id_cliente);

		List<String> itensCupom;
		List<List<String>> listaCupons = new java.util.ArrayList<List<String>>();
		for (int i = 0; i < entidades.size(); i++) {
			itensCupom = new java.util.ArrayList<String>();
			cupom = new Cupom();
			cupom = (Cupom) entidades.get(i);
			
			itensCupom.add(cupom.getCodigo());
			itensCupom.add(Double.toString(cupom.getValor()));
			itensCupom.add(cupom.getDataValidade());
			
			listaCupons.add(itensCupom);
			
		}
		request.setAttribute("listaCupons", listaCupons);
		try {
			request.getRequestDispatcher("site-meus-cupons.jsp").forward(request, response);
		} catch (ServletException ex) {
			Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
		}


		
	}

}
