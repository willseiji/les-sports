package br.com.les.viewhelper.impl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;
import br.com.les.viewhelper.IViewHelper;

public class ProdutoViewHelper implements IViewHelper {

	Produto produto = new Produto();

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");

		produto.setCodigoProd("");
		produto.setNome("");
		produto.setMaterial("");
		produto.setPeso(0);
		produto.setTamanho("");
		produto.setCategoria("");
		produto.setFabricante("");
		produto.setDescricao("");
		produto.setPreco(0);
		produto.setQuantidade(0);
		produto.setStatus("INATIVO");

		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")  ){
			
			System.out.println("operacao: "+operacao);
			String nmProduto = request.getParameter("txt_NmProduto");
			String nmMaterial = request.getParameter("txt_Material");
			String nmPeso = request.getParameter("txt_Peso");
			String nmTamanho = request.getParameter("txt_Tamanho");
			String nmCategoria = (request.getParameter("txt_Categoria"));
			String nmFabricante = (request.getParameter("txt_Fabricante"));
			String nmDescricao = request.getParameter("txt_Descricao");
			String nmPreco = request.getParameter("txt_Preco");
			String nmQuantidade = request.getParameter("txt_Quantidade");
			
			
			if(!nmProduto.isEmpty()||!nmProduto.trim().equals("")){
				produto.setNome(nmProduto);
			}
			if(!nmMaterial.isEmpty()||!nmMaterial.trim().equals("")){
				produto.setMaterial(nmMaterial);
			}
			if(!nmDescricao.isEmpty()||!nmDescricao.trim().equals("")){
				produto.setDescricao(nmDescricao);
			}
			if(!nmPeso.isEmpty()||!nmPeso.trim().equals("")){

				produto.setPeso(Double.parseDouble(nmPeso));
			}
			if(!nmTamanho.isEmpty()||!nmTamanho.trim().equals("")){	
				produto.setTamanho(nmTamanho);
			}

			if (!nmCategoria.isEmpty()||!nmCategoria.trim().equals("")) {
				produto.setCategoria(nmCategoria);
			}
			if (!nmFabricante.isEmpty()||!nmFabricante.trim().equals("")) {
				produto.setFabricante(nmFabricante);
			}
			if (!nmPreco.isEmpty()||!nmPreco.trim().equals("")) {
				produto.setPreco(Double.parseDouble(nmPreco));
			}
			if (!nmQuantidade.isEmpty()||!nmQuantidade.trim().equals("")) {
				produto.setQuantidade(Integer.parseInt(nmQuantidade));
			}
			
			System.out.println("mat: "+produto.getMaterial());

			//caso botão apertado foi o de 'value = PESQUISAR'
		}else if (operacao.equals("PESQUISAR")) {
			//recebendo valor de pesquisa
			String filtro = request.getParameter("txt_filtro");
			System.out.println("filtro: "+filtro);
			produto.setDescricao(filtro);
		} else if (operacao.equals("EXCLUIR")) {
			String idProduto = request.getParameter("txt_NmIdProduto");
			produto.setId(Integer.parseInt(idProduto));
		}else if (operacao.equals("PREALTERAR")) {
			//recebendo valor de pesquisa
			System.out.println("inicio de prealterar");
			String idProduto = request.getParameter("txt_IdProduto");
			System.out.println("id na VH na Home: "+idProduto );
			produto.setId(Integer.parseInt(idProduto));
			//caso botão apertado foi o de 'value = SALVAR'
		}else if (operacao.equals("ALTERAR")  ){
				
				System.out.println("operacao: "+operacao);
				String nmCodigo = request.getParameter("txt_Codigo");
				String nmProduto = request.getParameter("txt_NmProduto");
				String nmMaterial = request.getParameter("txt_Material");
				String nmPeso = request.getParameter("txt_Peso");
				String nmTamanho = request.getParameter("txt_Tamanho");
				String nmCategoria = (request.getParameter("txt_Categoria"));
				String nmFabricante = (request.getParameter("txt_Fabricante"));
				String nmDescricao = request.getParameter("txt_Descricao");

				
				if(!nmProduto.isEmpty()||!nmProduto.trim().equals("")){
					produto.setNome(nmProduto);
				}
				if(!nmMaterial.isEmpty()||!nmMaterial.trim().equals("")){
					produto.setMaterial(nmMaterial);
				}
				if(!nmDescricao.isEmpty()||!nmDescricao.trim().equals("")){
					produto.setDescricao(nmDescricao);
				}
				if(!nmPeso.isEmpty()||!nmPeso.trim().equals("")){
					produto.setPeso(Double.parseDouble(nmPeso));
				}
				if(!nmTamanho.isEmpty()||!nmTamanho.trim().equals("")){	
					produto.setTamanho(nmTamanho);
				}

				if (!nmCategoria.isEmpty()||!nmCategoria.trim().equals("")) {
					produto.setCategoria(nmCategoria);
				}
				if (!nmFabricante.isEmpty()||!nmFabricante.trim().equals("")) {
					produto.setFabricante(nmFabricante);
				}
				
				System.out.println("mat: "+produto.getMaterial());

		}//else if
		return produto;

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

			try {
				request.getRequestDispatcher("cadastro-produto.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


			//caso botão apertado foi o de 'value = PESQUISAR'
		} else if (operacao.equals("PESQUISAR")) {
			List<String> itensProduto;
			List<List<String>> listaProdutos = new java.util.ArrayList<List<String>>();
			int i;
			request.getSession().setAttribute("resultado", resultado);
			String view = request.getParameter("view");
			//caso a leitura no banco de dados não tenha encontrado nenhum dado

			if (resultado.getEntidades().isEmpty()) {
				request.setAttribute("listaProdutos", listaProdutos);
				try {
					request.getRequestDispatcher("menu-produto.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				for (i = 0; i < resultado.getEntidades().size(); i++) {
					itensProduto = new java.util.ArrayList<String>();
					Produto produto = (Produto) resultado.getEntidades().get(i);
					itensProduto.add(String.valueOf(produto.getId()));
					itensProduto.add(produto.getCodigoProd());
					itensProduto.add(produto.getNome());
					itensProduto.add(produto.getCategoria());
					itensProduto.add(produto.getFabricante());
					itensProduto.add(Integer.toString(produto.getQuantidade()));
					itensProduto.add(Double.toString(produto.getPreco()));
					itensProduto.add(produto.getStatus());
					itensProduto.add(Double.toString(produto.getPeso()));
					itensProduto.add(produto.getTamanho());
					itensProduto.add(produto.getDescricao());



					listaProdutos.add(itensProduto);
				}

				request.setAttribute("listaProdutos", listaProdutos);
				
				if(view.equals("adm")) {
					try {
						request.getRequestDispatcher("menu-produto.jsp").forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else {
					try {
						request.getRequestDispatcher("home.jsp").forward(request, response);
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

			List<String> itensProduto = null;

			request.getSession().setAttribute("resultado", resultado);
			String view = request.getParameter("view");
			
			if (resultado.getEntidades().isEmpty()) {
				System.out.println("está vazia");
				request.setAttribute("itensProduto", itensProduto);


				try {
					request.getRequestDispatcher("alterar-produto.jsp").forward(request, response);
				} catch (ServletException | IOException ex) {
					Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
				}
				//
				//caso a leitura no banco de dados tenha encontrado dados com sucesso
			} else {
				System.out.println("não está vazia");
				itensProduto = new java.util.ArrayList<String>();
				Produto produto = (Produto) resultado.getEntidades().get(0);
				System.out.println("produto: "+produto);
				System.out.println(produto.getNome());
				System.out.println(produto.getCategoria());
				System.out.println(produto.getMaterial());
				System.out.println(produto.getFabricante());
				
				itensProduto.add(String.valueOf(produto.getId()));
				itensProduto.add(produto.getCodigoProd());
				itensProduto.add(produto.getNome());
				itensProduto.add(produto.getCategoria());
				itensProduto.add(produto.getMaterial());
				itensProduto.add(produto.getTamanho());
				itensProduto.add(Double.toString(produto.getPeso()));
				itensProduto.add(produto.getFabricante());
				itensProduto.add(Double.toString(produto.getPreco()));
				itensProduto.add(Integer.toString(produto.getQuantidade()));
				itensProduto.add(produto.getDescricao());
				itensProduto.add(produto.getStatus());

				request.setAttribute("itensProduto", itensProduto);
				response.setContentType("text/html;charset=UTF-8");
				if(view.equals("adm")) {
					try {
						request.getRequestDispatcher("alterar-produto.jsp").forward(request, response);
					} catch (ServletException ex) {
						Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
					}
				}else {
					try {
						request.getRequestDispatcher("site-carrinho.jsp").forward(request, response);
					} catch (ServletException ex) {
						Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
					}
				
				}

			}
		} else if (operacao.equals("ALTERAR")) {

			try {
				request.getRequestDispatcher("menu-produto.jsp").forward(request, response);
			} catch (ServletException | IOException ex) {
				Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
			}

		}//else if


	}

}
