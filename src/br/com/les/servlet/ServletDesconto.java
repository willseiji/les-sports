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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ServletMeusPedidos
 */
@WebServlet("/ServleDesconto")
public class ServletDesconto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDesconto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		Cupom cupom =new Cupom();
		CupomDAO daoCupom = new CupomDAO();
		
		
		
		String valorCupom="0";
		String codigoCupom = request.getParameter("cod_cupom");
		System.out.println("codigo do cupom: "+codigoCupom);
		cupom.setCodigo(codigoCupom);
		
		List<EntidadeDominio> entidades  = daoCupom.pesquisar(cupom);
		System.out.println("codigo do cupom: "+codigoCupom);
		if(entidades.size()>0) {
				Cupom cupomDTO = (Cupom) entidades.get(0);
				valorCupom = Double.toString(cupomDTO.getValor());
		}
		
		/*JSONObject jsonCupom = new JSONObject();
		if("CUP00002".equals(codigoCupom)) {
			valorCupom="10";
			String status="cupom valido";
			
			
			jsonCupom.put("valor", valorCupom);
			jsonCupom.put("condicao", status);
			System.out.println("jsonCupom1: "+jsonCupom);
			
		}*/
		//System.out.println("jsonCupom2: "+jsonCupom);
//		response.setContentType("application/json");
//		response.getWriter().write(jsonCupom.toString());
		
		response.setContentType("text/plain");
		response.getWriter().write(valorCupom);
		System.out.println("saindo da Servlet");
		

		
	}

}
