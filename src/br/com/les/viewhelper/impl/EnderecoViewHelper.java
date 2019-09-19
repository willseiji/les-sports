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

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.Cidade;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Estado;
import br.com.les.dominio.impl.Usuario;
import br.com.les.viewhelper.IViewHelper;

public class EnderecoViewHelper implements IViewHelper {

	List<Endereco> enderecos = new ArrayList<>();
    Endereco endereco = new Endereco();
    Cidade cidade = new Cidade();
    Estado estado = new Estado();
    

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException {

		String operacao = request.getParameter("operacao");

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
			System.out.println("salvar");
			
			
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
			cidade.setEstado(estado);
			endereco.setCidade(cidade);
			endereco.setPrincipal("NÃO");
			
			HttpSession session = request.getSession(false);
			int id_cliente = (int) session.getAttribute("idCliente"); 
			
			endereco.setId_cliente(id_cliente);
			
			
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
			String idEndereco = request.getParameter("txt_IdEndereco");
			int id_Endereco = Integer.parseInt(idEndereco);
			endereco.setId(id_Endereco);
			
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
			try {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ClienteViewHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
			
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
			
			try {
				request.getRequestDispatcher("site-menu-carrinho.jsp").forward(request, response);
			} catch (ServletException ex) {
				Logger.getLogger(ProdutoViewHelper.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}//else if





	}

}
