package br.com.les.viewhelper.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.les.aplicacao.Resultado;
import br.com.les.dao.impl.PedidoDAO;
import br.com.les.dao.impl.ProdutoDAO;
import br.com.les.dominio.impl.Carrinho;
import br.com.les.dominio.impl.CartaoCredito;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.FormaPagamento;
import br.com.les.dominio.impl.Item;
import br.com.les.dominio.impl.ItemTroca;
import br.com.les.dominio.impl.ItensCartao;
import br.com.les.dominio.impl.Pagamento;
import br.com.les.dominio.impl.Pedido;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Troca;
import br.com.les.servico.impl.ClienteServico;
import br.com.les.viewhelper.IViewHelper;

public class TrocaViewHelper implements IViewHelper {

	
	Troca troca = new Troca();
	List<Troca> trocas = new ArrayList<>();
	ItemTroca itemTroca = new ItemTroca();
	List<ItemTroca> itemTrocas = new ArrayList<>();
	Pedido pedido = new Pedido(); 
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operacao = request.getParameter("operacao");
		
		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")  ){
			
			String json_trocas = request.getParameter("txt_json_trocas");
			
			//troca status, valor total
			
			System.out.println("json_trocas: "+json_trocas);
			
			JsonObject jsonTrocas = new JsonParser().parse(json_trocas).getAsJsonObject();
			int tamanho = jsonTrocas.getAsJsonArray("trocas").size();
			System.out.println("tamanho de itens no json: "+tamanho);
			
			for(int i=0;i<tamanho;i++) {
				JsonObject item_troca = (JsonObject) jsonTrocas.getAsJsonArray("trocas").get(i);
				int id_produto = item_troca.getAsJsonObject().get("id").getAsInt();
				int qtdeTrocada = item_troca.getAsJsonObject().get("qtde").getAsInt();
				double preco = item_troca.getAsJsonObject().get("preco").getAsDouble();
				
				System.out.println("id do produto: "+id_produto);
				System.out.println("qtde: "+qtdeTrocada);
				System.out.println("preco unit: "+preco);
			
				itemTroca= new ItemTroca();
				itemTroca.setQtdeTrocada(qtdeTrocada);
				itemTroca.setPreco(preco);
				itemTroca.setId_produto(id_produto);
				itemTrocas.add(itemTroca);
				
				
			}
			troca.setItensTroca(itemTrocas);
			
			HttpSession session = request.getSession();
			int id_cliente = (int) session.getAttribute("idCliente");
			
			troca.setId_cliente(id_cliente);
			troca.setStatus("TROCA SOLICITADA");
			troca.setValor_total();
			
			
			
			//caso botão apertado foi o de 'value = PESQUISAR'
		}else if (operacao.equals("PESQUISAR")) {
			//recebendo valor de pesquisa
			System.out.println("pesquisar");
			//recebendo valor de pesquisa
			String filtro = request.getParameter("txt_filtro");
			troca.setCodigo(filtro);
			
			
			
		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("excluir");
			
		}else if (operacao.equals("PREALTERAR")) {
			//recebendo valor de pesquisa
			System.out.println("prealterar");
			
			String idTroca = request.getParameter("txt_IdTroca");
			System.out.println("id em pre_alterar: "+idTroca);
			troca.setId(Integer.parseInt(idTroca));
			
			
			//caso botão apertado foi o de 'value = SALVAR'
		}else if (operacao.equals("ALTERAR")  ){
			
			
			int id_troca = Integer.parseInt(request.getParameter("txt_id"));
			String txt_Status = request.getParameter("txt_Status");

			troca.setId(id_troca);
			troca.setStatus(txt_Status);

			
			
			
		}//else if
		
		
		
		return troca;
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
			
			try {
				request.getRequestDispatcher("home.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


			//caso botão apertado foi o de 'value = PESQUISAR'
		} else if (operacao.equals("PESQUISAR")) {
			System.out.println("pesquisar ");
			
			System.out.println("operacao salvar");
			List<String> itensTroca;
			List<List<String>> listaTrocas = new java.util.ArrayList<List<String>>();
			int i;
			request.getSession().setAttribute("resultado", resultado);
			
			
			//caso a leitura no banco de dados não tenha encontrado nenhum dado

			if (resultado.getEntidades().isEmpty()) {
				request.setAttribute("listaTrocas", listaTrocas);
				try {
					request.getRequestDispatcher("visualizar-troca.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				for (i = 0; i < resultado.getEntidades().size(); i++) {
					itensTroca = new java.util.ArrayList<String>();
					Troca troca = (Troca) resultado.getEntidades().get(i);
					

	            	System.out.println("------------------------");
	            	System.out.println("id_pedido: "+troca.getId());
	            	System.out.println("codigo: "+troca.getCodigo());
	            	System.out.println("data: "+troca.getData());
	            	System.out.println("valor: "+troca.valorTotal());
	            	System.out.println("status: "+troca.getStatus());
					
	            	
	            	itensTroca.add(Integer.toString(troca.getId()));
	            	itensTroca.add(troca.getCodigo());
	            	itensTroca.add(troca.getData());
	            	itensTroca.add(Double.toString(troca.valorTotal()));
	            	itensTroca.add(troca.getStatus());
	            	
					listaTrocas.add(itensTroca);
				}

				request.setAttribute("listaTrocas", listaTrocas);
				try {
					request.getRequestDispatcher("menu-trocas.jsp").forward(request, response);
				} catch (ServletException ex) {
					Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
				}
				
			}//else

			

			
		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("Excluir");

		} else if (operacao.equals("PREALTERAR")) {
			System.out.println("Prealterar");
			
			
			String view = request.getParameter("view");

			System.out.println("====================");
			System.out.println("view: "+view);
			
			List<String> itens_Troca = new ArrayList<>();
			List<String> itensItensTroca = null;
			List<List<String>> listaItensItensTroca = new java.util.ArrayList<List<String>>();
						


			request.getSession().setAttribute("resultado", resultado);
			
			if (resultado.getEntidades().isEmpty()) {
				System.out.println("está vazia");
				request.setAttribute("itensTroca", itens_Troca);


				try {
					request.getRequestDispatcher("visualizar-troca.jsp").forward(request, response);
				} catch (ServletException | IOException ex) {
					Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
				}
				//
				//caso a leitura no banco de dados tenha encontrado dados com sucesso
			} else {
				System.out.println("não está vazia");
				Troca troca = (Troca) resultado.getEntidades().get(0);
				/*
				System.out.println("pedido: "+pedido);

            	System.out.println("------------------------");
            	System.out.println("id_pedido: "+pedido.getId());
            	System.out.println("codigo: "+pedido.getCodigo());
            	System.out.println("subtotal: "+pedido.getSubTotal());
            	System.out.println("frete: "+pedido.getValorFrete());
            	System.out.println("desconto: "+pedido.getValorDesconto());
            	System.out.println("total: "+pedido.getValorTotal());
            	System.out.println("status: "+pedido.getStatus());
            	
*/
				

            	System.out.println("------------------------");
            	System.out.println("id_troca: "+troca.getId());
            	System.out.println("codigo: "+troca.getCodigo());
            	System.out.println("data: "+troca.getData());
            	System.out.println("valor: "+troca.getValor_total());
            	System.out.println("status: "+troca.getStatus());
				
            	
            	itens_Troca.add(Integer.toString(troca.getId()));
            	itens_Troca.add(troca.getCodigo());
            	itens_Troca.add(troca.getData());
            	itens_Troca.add(Double.toString(troca.getValor_total()));
            	itens_Troca.add(troca.getStatus());
            	itens_Troca.add(Integer.toString(troca.getId_cliente()));
				
				
				for (int i = 0; i < troca.getItensTroca().size(); i++) {
					
					ItemTroca itemTroca = troca.getItensTroca().get(i);
					Produto produto = itemTroca.getProduto();
					
                	itensItensTroca = new java.util.ArrayList<String>();
                	itensItensTroca.add(Integer.toString(itemTroca.getId()));
                	itensItensTroca.add(produto.getCodigoProd());
                	itensItensTroca.add(produto.getNome());
                	itensItensTroca.add(produto.getMaterial());
                	itensItensTroca.add(produto.getFabricante());
                	itensItensTroca.add(produto.getTamanho());
                	itensItensTroca.add(Double.toString(produto.getPeso()));
                	itensItensTroca.add(Integer.toString(itemTroca.getQtdeTrocada()));
                	itensItensTroca.add(Double.toString(itemTroca.getPreco()));
                	itensItensTroca.add(Double.toString(itemTroca.valorTroca()));
                	itensItensTroca.add("Sem motivos"); //motivo da troca
                	
	                listaItensItensTroca.add(itensItensTroca);
                }//for
                
				
				request.setAttribute("itens_Troca", itens_Troca);
				request.setAttribute("listaItensItensTroca", listaItensItensTroca);
				response.setContentType("text/html;charset=UTF-8");
				try {
					request.getRequestDispatcher("visualizar-troca.jsp").forward(request, response);
				} catch (ServletException ex) {
					Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
				}

			}



		} else if (operacao.equals("ALTERAR")) {
			System.out.println("Alterar");
			
			try {
				request.getRequestDispatcher("menu-trocas.jsp").forward(request, response);
			} catch (ServletException ex) {
				Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
			}
						
		}//else if



	}

}
