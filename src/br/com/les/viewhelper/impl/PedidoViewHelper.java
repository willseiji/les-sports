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
import br.com.les.dominio.impl.ItensCartao;
import br.com.les.dominio.impl.Pagamento;
import br.com.les.dominio.impl.Pedido;
import br.com.les.dominio.impl.Produto;
import br.com.les.servico.impl.ClienteServico;
import br.com.les.viewhelper.IViewHelper;

public class PedidoViewHelper implements IViewHelper {

	Pedido pedido = new Pedido();
	
	Pagamento pagamento = new Pagamento();
	FormaPagamento formaPgto = new FormaPagamento();
	ItensCartao itensCartao = new ItensCartao();
	CartaoCredito cartao = new CartaoCredito();
	List<ItensCartao> listaItensCartao = new ArrayList<>();
	 
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operacao = request.getParameter("operacao");
		
		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")  ){
			
			HttpSession session = request.getSession();
			pedido = (Pedido) session.getAttribute("pedido");
			pedido.setStatus("PGTO APROVADO");
			
			
			String valorTotal = request.getParameter("txt_valorTotal");
			String qtdeParcelas = request.getParameter("txt_qtdeParcelas");
			String valorParcelas = request.getParameter("txt_valor_Parcelas");
			String json_cartoes = request.getParameter("txt_json_cartoes");
			
			
			System.out.println("qtdeParcelas: "+qtdeParcelas);
			System.out.println("valorParcelas: "+valorParcelas);
			System.out.println("valorTotal: "+valorTotal);
			System.out.println("json_cartoes: "+json_cartoes);
			
			JsonObject jsonCartoes = new JsonParser().parse(json_cartoes).getAsJsonObject();
			int tamanho = jsonCartoes.getAsJsonArray("itens_cartoes").size();
			System.out.println("tamanho de itens no json: "+tamanho);
			
			for(int i=0;i<tamanho;i++) {
				JsonObject item_cartao = (JsonObject) jsonCartoes.getAsJsonArray("itens_cartoes").get(i);
				int id_cartao = item_cartao.getAsJsonObject().get("id").getAsInt();
				double parcela = item_cartao.getAsJsonObject().get("parcela").getAsDouble();
				
				System.out.println("id do cartao: "+id_cartao);
				System.out.println("parcela do cartao: "+parcela);
				
				itensCartao = new ItensCartao();
				itensCartao.setId_cartao(id_cartao);
				itensCartao.setValor_parcela_cartao(parcela);
				listaItensCartao.add(itensCartao);
			}
			formaPgto.setQtdeParcelas(Integer.parseInt(qtdeParcelas));
			formaPgto.setValorParcelas(Double.parseDouble(valorParcelas));
			formaPgto.setItensCartao(listaItensCartao);
			
			pagamento.setTotal(Double.parseDouble(valorTotal));
			pagamento.setFormaPgto(formaPgto);
			
			pedido.setPagamento(pagamento);
			
			
			
			
			
			//caso botão apertado foi o de 'value = PESQUISAR'
		}else if (operacao.equals("PESQUISAR")) {
			//recebendo valor de pesquisa
			String filtro = request.getParameter("txt_filtro");
			String view = request.getParameter("view");
			HttpSession session = request.getSession();
			int id_cliente;
			System.out.println("view: "+view);
			
			if(view==null) { 
				id_cliente=-1;
				
			}else {
				if(session.getAttribute("idCliente")!=null) 
					id_cliente = (int) session.getAttribute("idCliente");
				else
					id_cliente=-1;
			}
			
			
			pedido.setFiltro(filtro);
			pedido.setId_cliente(id_cliente);
			
			
		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("excluir");
			
		}else if (operacao.equals("PREALTERAR")) {
			//recebendo valor de pesquisa
			System.out.println("prealterar");
			
			
			String idPedido = request.getParameter("txt_IdPedido");
			System.out.println("id em pre_alterar: "+idPedido);
			pedido.setId(Integer.parseInt(idPedido));
			
			
			//caso botão apertado foi o de 'value = SALVAR'
		}else if (operacao.equals("ALTERAR")  ){
			System.out.println("alterar");
			
			int id_pedido = Integer.parseInt(request.getParameter("txt_id"));
			String txt_Status = request.getParameter("txt_Status");

			pedido.setId(id_pedido);
			pedido.setStatus(txt_Status);

		}//else if
		
		return pedido;
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
			List<String> itensPedido;
			List<List<String>> listaPedidos = new java.util.ArrayList<List<String>>();
			int i;
			request.getSession().setAttribute("resultado", resultado);
			String view = request.getParameter("view");
			
			//caso a leitura no banco de dados não tenha encontrado nenhum dado

			if (resultado.getEntidades().isEmpty()) {
				request.setAttribute("listaPedidos", listaPedidos);
				try {
					request.getRequestDispatcher("menu-pedido.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				for (i = 0; i < resultado.getEntidades().size(); i++) {
					itensPedido = new java.util.ArrayList<String>();
					Pedido pedido = (Pedido) resultado.getEntidades().get(i);
					

	            	System.out.println("------------------------");
	            	System.out.println("id_pedido: "+pedido.getId());
	            	System.out.println("codigo: "+pedido.getCodigo());
	            	System.out.println("nome: "+pedido.getCliente().getNome());
	            	System.out.println("valor: "+pedido.getValorTotal());
	            	System.out.println("status: "+pedido.getStatus());
					
	            	itensPedido.add(Integer.toString(pedido.getId()));
	            	itensPedido.add(pedido.getCodigo());
					itensPedido.add(pedido.getCliente().getNome());
					itensPedido.add(pedido.getData());
					itensPedido.add(Double.toString(pedido.getValorTotal()));
					itensPedido.add(pedido.getStatus());
					
					listaPedidos.add(itensPedido);
				}

				request.setAttribute("listaPedidos", listaPedidos);
				if(view==null) {
					try {
						request.getRequestDispatcher("menu-pedido.jsp").forward(request, response);
					} catch (ServletException ex) {
						Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
					}
				}else {
					try {
						request.getRequestDispatcher("site-meus-pedidos.jsp").forward(request, response);
					} catch (ServletException ex) {
						Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
					}
				
				}

				
			}//else

			
			
			
		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("Excluir");

		} else if (operacao.equals("PREALTERAR")) {
			
			System.out.println("Prealterar");
			String view = request.getParameter("view");

			System.out.println("====================");
			System.out.println("view: "+view);
			
			List<String> itensPedido = new ArrayList<>();
			List<String> itensCliente = null;
			List<String> itensEndereco = null;
			List<List<String>> listaEnderecos = new java.util.ArrayList<List<String>>();
			List<String> itensItem = null;
			List<List<String>> listaItens = new java.util.ArrayList<List<String>>();
			List<String> itensCartao = null;
			List<List<String>> listaCartoes = new java.util.ArrayList<List<String>>();
			


			request.getSession().setAttribute("resultado", resultado);
			
			if (resultado.getEntidades().isEmpty()) {
				System.out.println("está vazia");
				request.setAttribute("itensPedido", itensPedido);


				try {
					request.getRequestDispatcher("visualizar-pedido.jsp").forward(request, response);
				} catch (ServletException | IOException ex) {
					Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
				}
				//
				//caso a leitura no banco de dados tenha encontrado dados com sucesso
			} else {
				System.out.println("não está vazia");
				itensCliente = new ArrayList<>();
				Pedido pedido = (Pedido) resultado.getEntidades().get(0);
				
				System.out.println("pedido: "+pedido);

            	System.out.println("------------------------");
            	System.out.println("id_pedido: "+pedido.getId());
            	System.out.println("codigo: "+pedido.getCodigo());
            	System.out.println("subtotal: "+pedido.getSubTotal());
            	System.out.println("frete: "+pedido.getValorFrete());
            	System.out.println("desconto: "+pedido.getValorDesconto());
            	System.out.println("total: "+pedido.getValorTotal());
            	System.out.println("status: "+pedido.getStatus());
            	

				
            	itensPedido.add(Integer.toString(pedido.getId()));
				itensPedido.add(pedido.getCodigo());
				itensPedido.add(pedido.getData());
				itensPedido.add(Double.toString(pedido.getSubTotal()));
				itensPedido.add(Double.toString(pedido.getValorFrete()));
				itensPedido.add(Double.toString(pedido.getValorDesconto()));
				itensPedido.add(Double.toString(pedido.getValorTotal()));
				itensPedido.add(pedido.getStatus());
				System.out.println("------------------------");
				System.out.println("status do pedido em pre alterar da VH: "+itensPedido.get(7));
				
				Cliente cliente = pedido.getCliente();
				
            	itensCliente.add(Integer.toString(cliente.getId()));
				itensCliente.add(cliente.getCodigo());
				itensCliente.add(cliente.getNome());
				itensCliente.add(cliente.getSexo());
				itensCliente.add(cliente.getDtNasc());
				itensCliente.add(cliente.getRg());
				itensCliente.add(cliente.getCpf());
				itensCliente.add(cliente.getEmail());
				itensCliente.add(cliente.getTelefone());
				itensCliente.add(cliente.getStatus());

				for (int i = 0; i < cliente.getEnderecos().size(); i++) {
					
					Endereco endereco = cliente.getEnderecos().get(i);
					
					System.out.println("------------------------");
					System.out.println("id_endereco: "+endereco.getId());
	            	System.out.println("rua: "+endereco.getRua());
	            	System.out.println("numero: "+endereco.getRua());
	            	System.out.println("complemento: "+endereco.getComplemento());
	            	System.out.println("bairro: "+endereco.getBairro());
	            	System.out.println("cep: "+endereco.getCep());
	            	System.out.println("cidade: "+endereco.getCidade().getNome());
	            	System.out.println("estado: "+endereco.getCidade().getEstado().getNome());
	            	System.out.println("tipo endereco: "+endereco.getTipoEndereco());
	            	System.out.println("principal: "+endereco.getPrincipal());
	            	
					
                	itensEndereco = new java.util.ArrayList<String>();
                	itensEndereco.add(Integer.toString(endereco.getId()));
                	itensEndereco.add(endereco.getRua());
	                itensEndereco.add(endereco.getNumero());
	                itensEndereco.add(endereco.getComplemento());
	                itensEndereco.add(endereco.getBairro());
	                itensEndereco.add(endereco.getCep());
	                itensEndereco.add(endereco.getCidade().getNome());
	                itensEndereco.add(endereco.getCidade().getEstado().getNome());
	                itensEndereco.add(endereco.getTipoEndereco());
	                itensEndereco.add(endereco.getPrincipal());
	                
	                listaEnderecos.add(itensEndereco);
                }//for
                
				
				for (int i = 0; i < cliente.getCartoes().size(); i++) {
					
					CartaoCredito cartao = cliente.getCartoes().get(i);

					
					System.out.println("------------------------");
					System.out.println("id_cartao: "+cartao.getId());
	            	System.out.println("bandeira: "+cartao.getBandeira());
	            	System.out.println("numero: "+cartao.getNumero());
	            	System.out.println("codigo seguranca: "+cartao.getCodigoSeguranca());
	            	System.out.println("validade: "+cartao.getDataValidade());
	            	System.out.println("nome titular: "+cartao.getNomeTitular());
	            		
                	itensCartao = new java.util.ArrayList<String>();
                	itensCartao.add(Integer.toString(cartao.getId()));
                	itensCartao.add(cartao.getBandeira());
                	itensCartao.add(cartao.getNumero());
                	itensCartao.add(cartao.getCodigoSeguranca());
                	itensCartao.add(cartao.getDataValidade());
                	itensCartao.add(cartao.getNomeTitular());
                	
	                
	                listaCartoes.add(itensCartao);
                }//for
                
				
				
				for (int i = 0; i < pedido.getItens().size(); i++) {
					
					Item item = pedido.getItens().get(i);
					Produto produto = item.getProduto();
					System.out.println("produto: "+produto);
					System.out.println("id_item: "+item.getId());
					System.out.println("id_produto: "+produto.getId());
	            	System.out.println("codigo produto: "+produto.getCodigoProd());
	            	
					
                	itensItem = new java.util.ArrayList<String>();
                	itensItem.add(Integer.toString(item.getId()));
                	itensItem.add(item.getProduto().getCodigoProd());
                	itensItem.add(item.getProduto().getNome());
                	itensItem.add(item.getProduto().getMaterial());
                	itensItem.add(item.getProduto().getFabricante());
                	itensItem.add(item.getProduto().getTamanho());
                	itensItem.add(Double.toString(item.getProduto().getPeso()));
                	itensItem.add(Integer.toString(item.getQtde()));
                	itensItem.add(Double.toString(item.getProduto().getPreco()));
                	itensItem.add(Double.toString(item.getSubTotal()));
                	itensItem.add(Integer.toString(item.getProduto().getId()));
                	System.out.println("ID ---- :"+itensItem.get(0));
                	
	                listaItens.add(itensItem);
                }//for
                
				
				request.setAttribute("itensPedido", itensPedido);
				request.setAttribute("itensCliente", itensCliente);
				request.setAttribute("listaEnderecos", listaEnderecos);
				request.setAttribute("listaItens", listaItens);
				request.setAttribute("listaCartoes", listaCartoes);
				response.setContentType("text/html;charset=UTF-8");
				if(view.equals("cliente")) {
					try {
						request.getRequestDispatcher("site-trocas.jsp").forward(request, response);
					} catch (ServletException ex) {
						Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
					}
				}else {
					try {
						request.getRequestDispatcher("visualizar-pedido.jsp").forward(request, response);
					} catch (ServletException ex) {
						Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
					}
				}

			}


			
		} else if (operacao.equals("ALTERAR")) {
			System.out.println("Alterar");
			try {
				request.getRequestDispatcher("menu-pedido.jsp").forward(request, response);
			} catch (ServletException | IOException ex) {
				Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
			}

			
		}//else if



	}

}
