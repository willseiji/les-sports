package br.com.les.viewhelper.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.Cidade;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Estado;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Usuario;
import br.com.les.viewhelper.IViewHelper;

public class ClienteViewHelper implements IViewHelper {

	Cliente cliente = new Cliente();
	List<Endereco> enderecos = new ArrayList<>();
    Endereco endereco = new Endereco();
    Cidade cidade = new Cidade();
    Estado estado = new Estado();
    Usuario usuario = new Usuario();
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");

		cliente.setNome("");
		cliente.setNome("");
		cliente.setRg("");
		cliente.setCpf("");
		cliente.setEmail("");
		cliente.setTelefone("");
		usuario.setNome("");
		usuario.setSenha("");
		endereco.setRua("");
		endereco.setNumero("");
		endereco.setComplemento("");
		endereco.setBairro("");
		endereco.setCep("");
		cidade.setNome("");
		estado.setNome("");
		endereco.setTipoEndereco("");

		//caso botão apertado foi o de 'value = SALVAR'
		if (operacao.equals("SALVAR")  ){
			
							
				String nmCliente = request.getParameter("txt_NmCliente");
				String nmDtNasc = request.getParameter("txt_DtNasc");
				String nmSexo = request.getParameter("txt_Sexo");
				String nmRG = request.getParameter("txt_RG");
				String nmCPF = request.getParameter("txt_CPF");
				String nmEmail = request.getParameter("txt_Email");
				String nmTelefone = request.getParameter("txt_Telefone");
				String nmLogin = request.getParameter("txt_Login");
				String nmSenha = request.getParameter("txt_Senha");
				String nmSenha2 = request.getParameter("txt_Senha2");
				String nmRua = request.getParameter("txt_Rua");
				String nmEnderecoNum = request.getParameter("txt_EnderecoNum");
				String nmComplemento = request.getParameter("txt_Complemento");
				String nmBairro = request.getParameter("txt_Bairro");
				String nmCEP = request.getParameter("txt_CEP");
				String nmCidade = request.getParameter("txt_Cidade");
				String nmEstado = request.getParameter("txt_Estado");
				String nmTipoEndereco = request.getParameter("txt_TipoEndereco");


				if(!nmCliente.isEmpty()||!nmCliente.trim().equals("")){
					cliente.setNome(nmCliente);
				}
				if(!nmDtNasc.isEmpty()||!nmDtNasc.trim().equals("")){
					cliente.setDtNasc(nmDtNasc);
				}
				if(!nmSexo.isEmpty()||!nmSexo.trim().equals("")){
					cliente.setSexo(nmSexo);
				}
				if(!nmRG.isEmpty()||!nmRG.trim().equals("")){
					cliente.setRg(nmRG);
				}
				if(!nmCPF.isEmpty()||!nmCPF.trim().equals("")){
					cliente.setCpf(nmCPF);
				}
				if(!nmEmail.isEmpty()||!nmEmail.trim().equals("")){
					cliente.setEmail(nmEmail);
				}
				if(!nmTelefone.isEmpty()||!nmTelefone.trim().equals("")){
					cliente.setTelefone(nmTelefone);
				}
				if(!nmLogin.isEmpty()||!nmLogin.trim().equals("")){
					usuario.setNome(nmLogin);
				}
				if(!nmSenha.isEmpty()||!nmSenha.trim().equals("")){
					usuario.setSenha(nmSenha);
				}
				if(!nmRua.isEmpty()||!nmRua.trim().equals("")){
					endereco.setRua(nmRua);
				}
				if(!nmEnderecoNum.isEmpty()||!nmEnderecoNum.trim().equals("")){
					endereco.setNumero(nmEnderecoNum);
				}
				if(!nmComplemento.isEmpty()||!nmComplemento.trim().equals("")){
					endereco.setComplemento(nmComplemento);
				}
				if(!nmBairro.isEmpty()||!nmBairro.trim().equals("")){
					endereco.setBairro(nmBairro);
				}
				if(!nmCEP.isEmpty()||!nmCEP.trim().equals("")){
					endereco.setCep(nmCEP);
				}
				if(!nmCidade.isEmpty()||!nmCidade.trim().equals("")){
					cidade.setNome(nmCidade);
				}
				if(!nmEstado.isEmpty()||!nmEstado.trim().equals("")){
					estado.setNome(nmEstado);
				}
				if(!nmTipoEndereco.isEmpty()||!nmTipoEndereco.trim().equals("")){
					endereco.setTipoEndereco(nmTipoEndereco);
				}
				cliente.setUsuario(usuario);
				cidade.setEstado(estado);
				endereco.setCidade(cidade);
				enderecos.add(endereco);
				cliente.setEnderecos(enderecos);

				//caso botão apertado foi o de 'value = PESQUISAR'
		}else if (operacao.equals("PESQUISAR")) {
			//recebendo valor de pesquisa
			String filtro = request.getParameter("txt_filtro");
			cliente.setNome(filtro);
		} else if (operacao.equals("EXCLUIR")) {
			String idCliente = request.getParameter("txt_NmIdCliente");
			cliente.setId(Integer.parseInt(idCliente));
		}else if (operacao.equals("PREALTERAR")) {
			//recebendo valor de pesquisa
			System.out.println("inicio de prealterar");
			String codCliente = request.getParameter("txt_NmCodigo");
			
			cliente.setCodigo(codCliente);
			//caso botão apertado foi o de 'value = SALVAR'
		}else if (operacao.equals("ALTERAR")  ){
			
			
			String nmCodigo = request.getParameter("txt_Codigo");
			String nmCliente = request.getParameter("txt_NmCliente");
			String nmDtNasc = request.getParameter("txt_DtNasc");
			String nmRG = request.getParameter("txt_RG");
			String nmCPF = request.getParameter("txt_CPF");
			String nmEmail = request.getParameter("txt_Email");
			String nmTelefone = request.getParameter("txt_Telefone");

			if(!nmCodigo.isEmpty()||!nmCodigo.trim().equals("")){
				cliente.setCodigo(nmCodigo);
			}
			if(!nmCliente.isEmpty()||!nmCliente.trim().equals("")){
				cliente.setNome(nmCliente);
			}
			if(!nmDtNasc.isEmpty()||!nmDtNasc.trim().equals("")){
				cliente.setDtNasc(nmDtNasc);
			}
			if(!nmRG.isEmpty()||!nmRG.trim().equals("")){
				cliente.setRg(nmRG);
			}
			if(!nmCPF.isEmpty()||!nmCPF.trim().equals("")){
				cliente.setCpf(nmCPF);
			}
			if(!nmEmail.isEmpty()||!nmEmail.trim().equals("")){
				cliente.setEmail(nmEmail);
			}
			if(!nmTelefone.isEmpty()||!nmTelefone.trim().equals("")){
				cliente.setTelefone(nmTelefone);
			}

		}//else if
		return cliente;
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
				request.getRequestDispatcher("menu-cliente.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


			//caso botão apertado foi o de 'value = PESQUISAR'
		} else if (operacao.equals("PESQUISAR")) {
			System.out.println("operacao salvar");
			List<String> itensCliente;
			List<List<String>> listaClientes = new java.util.ArrayList<List<String>>();
			int i;
			request.getSession().setAttribute("resultado", resultado);
			//caso a leitura no banco de dados não tenha encontrado nenhum dado

			if (resultado.getEntidades().isEmpty()) {
				request.setAttribute("listaClientes", listaClientes);
				try {
					request.getRequestDispatcher("menu-cliente.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				for (i = 0; i < resultado.getEntidades().size(); i++) {
					itensCliente = new java.util.ArrayList<String>();
					Cliente cliente = (Cliente) resultado.getEntidades().get(i);
					

	            	System.out.println("------------------------");
	            	System.out.println("id_cliente: "+cliente.getId());
	            	System.out.println("codigo: "+cliente.getCodigo());
	            	System.out.println("nome: "+cliente.getNome());
	            	System.out.println("email: "+cliente.getEmail());
	            	System.out.println("status: "+cliente.getStatus());
					
	            	itensCliente.add(cliente.getCodigo());
					itensCliente.add(cliente.getNome());
					itensCliente.add(cliente.getEmail());
					itensCliente.add(cliente.getStatus());
					
					
					listaClientes.add(itensCliente);
				}

				request.setAttribute("listaClientes", listaClientes);
				try {
					request.getRequestDispatcher("menu-cliente.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}//else

		} else if (operacao.equals("EXCLUIR")) {
			System.out.println("Excluir");

		} else if (operacao.equals("PREALTERAR")) {
			System.out.println("Prealterar");

			List<String> itensCliente = null;
			List<String> itensEndereco = null;
			List<List<String>> listaEnderecos = new java.util.ArrayList<List<String>>();

			request.getSession().setAttribute("resultado", resultado);
			
			if (resultado.getEntidades().isEmpty()) {
				System.out.println("está vazia");
				request.setAttribute("itensCliente", itensCliente);


				try {
					request.getRequestDispatcher("alterar-cliente.jsp").forward(request, response);
				} catch (ServletException | IOException ex) {
					Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
				}
				//
				//caso a leitura no banco de dados tenha encontrado dados com sucesso
			} else {
				System.out.println("não está vazia");
				itensCliente = new java.util.ArrayList<String>();
				Cliente cliente = (Cliente) resultado.getEntidades().get(0);
				

            	System.out.println("------------------------");
            	System.out.println("id_cliente: "+cliente.getId());
            	System.out.println("codigo: "+cliente.getCodigo());
            	System.out.println("dtNasc: "+cliente.getDtNasc());
            	System.out.println("nome: "+cliente.getNome());
            	System.out.println("sexo: "+cliente.getSexo());
            	System.out.println("rg: "+cliente.getRg());
            	System.out.println("cpf: "+cliente.getCpf());
            	System.out.println("email: "+cliente.getEmail());
            	System.out.println("telefone: "+cliente.getTelefone());
            	System.out.println("status: "+cliente.getStatus());

				
				itensCliente.add(cliente.getCodigo());
				itensCliente.add(cliente.getNome());
				itensCliente.add(cliente.getDtNasc());
				itensCliente.add(cliente.getSexo());
				itensCliente.add(cliente.getRg());
				itensCliente.add(cliente.getCpf());
				itensCliente.add(cliente.getEmail());
				itensCliente.add(cliente.getTelefone());
				itensCliente.add(cliente.getStatus());
				
				for (int i = 0; i < cliente.getEnderecos().size(); i++) {
					
					Endereco endereco = cliente.getEnderecos().get(i);
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
	                
	                listaEnderecos.add(itensEndereco);
                }//for
                
				
				request.setAttribute("itensCliente", itensCliente);
				//request.setAttribute("listaEnderecos", listaEnderecos);
				response.setContentType("text/html;charset=UTF-8");
				try {
					request.getRequestDispatcher("alterar-cliente.jsp").forward(request, response);
				} catch (ServletException ex) {
					Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
				}

			}


			
		} else if (operacao.equals("ALTERAR")) {

			try {
				request.getRequestDispatcher("menu-cliente.jsp").forward(request, response);
			} catch (ServletException | IOException ex) {
				Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
			}

		}//else if




	}

}
