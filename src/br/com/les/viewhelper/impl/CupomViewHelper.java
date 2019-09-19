package br.com.les.viewhelper.impl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.Cupom;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;
import br.com.les.viewhelper.IViewHelper;

public class CupomViewHelper implements IViewHelper {

	Cupom cupom = new Cupom();

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");

		
		cupom.setData("");
		cupom.setId_cliente(0);
		cupom.setValor(0);
		
		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")  ){
			
			System.out.println("operacao: "+operacao);
			String nmIdCliente = request.getParameter("txt_IdCliente");
			String nmTotal = request.getParameter("txt_Total");
			
			if(!nmIdCliente.isEmpty()||!nmIdCliente.trim().equals("")){
				cupom.setId_cliente(Integer.parseInt(nmIdCliente));
			}
			if(!nmTotal.isEmpty()||!nmTotal.trim().equals("")){
				cupom.setValor(Double.parseDouble(nmTotal));
			}
						
			
			//caso botão apertado foi o de 'value = PESQUISAR'
		}else if (operacao.equals("PESQUISAR")) {
			//recebendo valor de pesquisa
			String filtro = request.getParameter("txt_filtro");
			System.out.println("filtro: "+filtro);
			cupom.setCodigo(filtro);
			
		} else if (operacao.equals("EXCLUIR")) {
			String idCupom = request.getParameter("txt_NmIdCupom");
			cupom.setId(Integer.parseInt(idCupom));
		}else if (operacao.equals("PREALTERAR")) {
			//recebendo valor de pesquisa
			System.out.println("inicio de prealterar");
			
			//caso botão apertado foi o de 'value = SALVAR'
		}else if (operacao.equals("ALTERAR")  ){
			System.out.println("inicio de alterar");		
		}//else if
		return cupom;

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
		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")) {
			System.out.println("tela salvar da ");
			request.getSession().setAttribute("resultado", resultado);
			Cupom cupom = (Cupom) resultado.getEntidades().get(0);
			request.setAttribute("mensagem", "Codigo de Cupom gerado: "+cupom.getCodigo() );
			
			try {
				request.getRequestDispatcher("menu-trocas.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


			//caso botão apertado foi o de 'value = PESQUISAR'
		} else if (operacao.equals("PESQUISAR")) {
			List<String> itensCupom;
			List<List<String>> listaCupons = new java.util.ArrayList<List<String>>();
			int i;
			request.getSession().setAttribute("resultado", resultado);
			String view = request.getParameter("view");
			//caso a leitura no banco de dados não tenha encontrado nenhum dado

			if (resultado.getEntidades().isEmpty()) {
				request.setAttribute("listaCupons", listaCupons);
				try {
					request.getRequestDispatcher("menu-cupom.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				for (i = 0; i < resultado.getEntidades().size(); i++) {
					itensCupom = new java.util.ArrayList<String>();
					Cupom cupom = (Cupom) resultado.getEntidades().get(i);
					
					
			    	itensCupom.add(Integer.toString(cupom.getId()));
	            	itensCupom.add(cupom.getCodigo());
	            	itensCupom.add(cupom.getData());
	            	itensCupom.add(Double.toString(cupom.getValor()));
	            	itensCupom.add(Integer.toString(cupom.getId_cliente()));
	            	
	            	listaCupons.add(itensCupom);
				}

				request.setAttribute("listaCupons", listaCupons);
				
				if(view.equals("adm")) {
					try {
						request.getRequestDispatcher("menu-cupom.jsp").forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else {
					try {
						request.getRequestDispatcher("meus-cupons.jsp").forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}//else

		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("Excluir");

		} else if (operacao.equals("PREALTERAR")) {
			System.out.println("Prealterar");

		} else if (operacao.equals("ALTERAR")) {
			System.out.println("Alterar");
		
		}//else if


	}

}
