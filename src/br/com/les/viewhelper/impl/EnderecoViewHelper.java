package br.com.les.viewhelper.impl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.viewhelper.IViewHelper;

public class EnderecoViewHelper implements IViewHelper {


	Endereco endereco= new Endereco();
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");

		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")  ){
			System.out.println("salvar");
			//caso botão apertado foi o de 'value = PESQUISAR'
		}else if (operacao.equals("PESQUISAR")) {
			//recebendo valor de pesquisa
			System.out.println("pesquisar");
		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("dentro de excluir");
			String idEndereco = request.getParameter("txt_IdEndereco");
			int id_Endereco = Integer.parseInt(idEndereco);
			System.out.println("idEndereco: "+id_Endereco);
			endereco.setId(id_Endereco);
		}else if (operacao.equals("PREALTERAR")) {
			//recebendo valor de pesquisa
			System.out.println("inicio de prealterar");

			//caso botão apertado foi o de 'value = SALVAR'
		}else if (operacao.equals("ALTERAR")  ){

			System.out.println("inicio de alterar");

		}//else if
		return endereco;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operacao = request.getParameter("operacao");
		//recupera mensagem criada na fachada com texto de sucesso ou falha nas regras de negocio ou acesso ao DAO
		String msg = resultado.getMsg();
		//envia mensagem para o request
		request.setAttribute("msg", msg);

		System.out.println("dentro da set view helper");
		
		if (operacao.equals("SALVAR")) {
			System.out.println("operacao salvar");
			
		} else if (operacao.equals("PESQUISAR")) {
			System.out.println("operacao salvar");
			
		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("Excluir");
			try {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ClienteViewHelper.class.getName()).log(Level.SEVERE, null, ex);
            }

		} else if (operacao.equals("PREALTERAR")) {
			System.out.println("Prealterar");
			

		} else if (operacao.equals("ALTERAR")) {
			System.out.println("operacao alterar");
			
		}//else if





	}

}
