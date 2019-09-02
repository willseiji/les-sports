package br.com.les.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xml.internal.serialize.Printer;

import br.com.les.dao.impl.ClienteDAO;
import br.com.les.dao.impl.UsuarioDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		
		
		List<Usuario> usuarios = new ArrayList<>();
		PrintWriter out=response.getWriter();
		
		
		 String nome = request.getParameter("txt_nome");
		 String senha = request.getParameter("txt_senha");
		 usuario.setNome(nome);
		 usuario.setSenha(senha);
		 
		 UsuarioDAO daoUsuario = new UsuarioDAO();
		 List<EntidadeDominio> entidades = daoUsuario.pesquisar(usuario);
		 Usuario user = (Usuario) entidades.get(0);
		 
		 if(entidades!=null) {
			 
			 int id_usuario = user.getId();
			 System.out.println("id_user: "+id_usuario);
			 Cliente cliente = new Cliente();
			 ClienteDAO daoCliente = new ClienteDAO();
			 
			 cliente = (Cliente) daoCliente.findUsuario(id_usuario);
			 System.out.println("cliente: "+cliente);
			 System.out.println("cliente codigo: "+cliente.getCodigo());
			 
			 HttpSession session = request.getSession();
			 session.setAttribute("idCliente",cliente.getId());
			 request.getRequestDispatcher("loginOutput.jsp").forward(request,response);
			 
			 int id = (int) session.getAttribute("idCliente");
			 System.out.println("codigo na sessao: "+id);
			 
		 }else {
			 System.out.println("falha de login");
			 out.print("erro no login");
			 request.getRequestDispatcher("login.jsp").include(request,response);
		 }
		 
		out.close(); 
		
	}

}
