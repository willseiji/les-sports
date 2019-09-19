package br.com.les.viewhelper.impl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.CartaoCredito;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;
import br.com.les.viewhelper.IViewHelper;

public class CartaoViewHelper implements IViewHelper {

	
	CartaoCredito cartao = new CartaoCredito();

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");

		cartao.setBandeira("");
		cartao.setNumero("");
		cartao.setCodigoSeguranca("");
		cartao.setDataValidade("");
		cartao.setNomeTitular("");
		cartao.setPrincipal("");
		
		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")  ){
			
			System.out.println("operacao: "+operacao);
			String nmBandeira = request.getParameter("txt_Bandeira");
			String nmCartaoNum = request.getParameter("txt_CartaoNum");
			String nmCV = request.getParameter("txt_CV");
			String nmVencimento = request.getParameter("txt_Vencimento");
			String nmTitular = (request.getParameter("txt_Titular"));
			
			
			if(!nmBandeira.isEmpty()||!nmBandeira.trim().equals("")){
				cartao.setBandeira(nmBandeira);
			}
			if(!nmCartaoNum.isEmpty()||!nmCartaoNum.trim().equals("")){
				cartao.setNumero(nmCartaoNum);
			}
			if(!nmCV.isEmpty()||!nmCV.trim().equals("")){
				cartao.setCodigoSeguranca(nmCV);
			}
			if(!nmVencimento.isEmpty()||!nmVencimento.trim().equals("")){
				cartao.setDataValidade(nmVencimento);
			}
			if(!nmTitular.isEmpty()||!nmTitular.trim().equals("")){
				cartao.setNomeTitular(nmTitular);
			}
			cartao.setPrincipal("Não");
			
			HttpSession session = request.getSession(false);
			int id_cliente = (int) session.getAttribute("idCliente"); 

			cartao.setId_cliente(id_cliente);
			
			//caso botão apertado foi o de 'value = PESQUISAR'
		}else if (operacao.equals("PESQUISAR")) {
			//recebendo valor de pesquisa
			String filtro = request.getParameter("txt_filtro");
			System.out.println("filtro: "+filtro);
			cartao.setNomeTitular(filtro);
		} else if (operacao.equals("EXCLUIR")) {
			String idCartao = request.getParameter("txt_IdCartao");
			cartao.setId(Integer.parseInt(idCartao));
		}else if (operacao.equals("PREALTERAR")) {
			//recebendo valor de pesquisa
			System.out.println("inicio de prealterar");
			String idCartao = request.getParameter("txt_IdCartao");
			System.out.println("id na VH na Home: "+idCartao );
			cartao.setId(Integer.parseInt(idCartao));
			//caso botão apertado foi o de 'value = SALVAR'
		}else if (operacao.equals("ALTERAR")  ){
			System.out.println("alterar");
			String nmBandeira = request.getParameter("txt_Bandeira");
			String nmCartaoNum = request.getParameter("txt_CartaoNum");
			String nmCV = request.getParameter("txt_CV");
			String nmVencimento = request.getParameter("txt_Vencimento");
			String nmTitular = (request.getParameter("txt_Titular"));
			String nmPrincipal = (request.getParameter("txt_Principal"));
			
			if(!nmBandeira.isEmpty()||!nmBandeira.trim().equals("")){
				cartao.setBandeira(nmBandeira);
			}
			if(!nmCartaoNum.isEmpty()||!nmCartaoNum.trim().equals("")){
				cartao.setNumero(nmCartaoNum);
			}
			if(!nmCV.isEmpty()||!nmCV.trim().equals("")){
				cartao.setCodigoSeguranca(nmCV);
			}
			if(!nmVencimento.isEmpty()||!nmVencimento.trim().equals("")){
				cartao.setDataValidade(nmVencimento);
			}
			if(!nmTitular.isEmpty()||!nmTitular.trim().equals("")){
				cartao.setNomeTitular(nmTitular);
			}
			if(!nmPrincipal.isEmpty()||!nmPrincipal.trim().equals("")){
				cartao.setPrincipal(nmPrincipal);
			}



		}//else if
		return cartao;

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

		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")) {
			try {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ClienteViewHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
			
			//caso botão apertado foi o de 'value = PESQUISAR'
		} else if (operacao.equals("PESQUISAR")) {
			System.out.println("pesquisar");
			
		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("Excluir");

		} else if (operacao.equals("PREALTERAR")) {
			System.out.println("Prealterar");

		} else if (operacao.equals("ALTERAR")) {
			System.out.println("alterar");
			
		}//else if


	}

}
