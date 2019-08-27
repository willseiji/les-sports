package br.com.les.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import br.com.les.aplicacao.Resultado;
import br.com.les.command.ICommand;
import br.com.les.command.impl.AlterarCommand;
import br.com.les.command.impl.ExcluirCommand;
import br.com.les.command.impl.PesquisarCommand;
import br.com.les.command.impl.PreAlterarCommand;
import br.com.les.command.impl.SalvarCommand;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.viewhelper.IViewHelper;
import br.com.les.viewhelper.impl.ClienteViewHelper;
import br.com.les.viewhelper.impl.EnderecoViewHelper;
import br.com.les.viewhelper.impl.ProdutoViewHelper;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, IViewHelper> vhs;
    private static Map<String, ICommand> commands;

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
        vhs = new HashMap<String, IViewHelper>();
        
        //mapeando URI com tipo de instância de produto para View Helper
          vhs.put("/les-codigo/CadastrarProduto", new ProdutoViewHelper());
          vhs.put("/les-codigo/PesquisarProduto", new ProdutoViewHelper());
          vhs.put("/les-codigo/ExcluirProduto", new ProdutoViewHelper());
          vhs.put("/les-codigo/PreAlterarProduto", new ProdutoViewHelper());
          vhs.put("/les-codigo/AlterarProduto", new ProdutoViewHelper());

          
          //mapeando URI com tipo de instância de cliente para View Helper
          vhs.put("/les-codigo/CadastrarCliente", new ClienteViewHelper());
          vhs.put("/les-codigo/PesquisarCliente", new ClienteViewHelper());
          vhs.put("/les-codigo/ExcluirCliente", new ClienteViewHelper());
          vhs.put("/les-codigo/PreAlterarCliente", new ClienteViewHelper());
          vhs.put("/les-codigo/AlterarCliente", new ClienteViewHelper());

          //mapeando URI com tipo de instância de endereco para View Helper
          vhs.put("/les-codigo/CadastrarEndereco", new EnderecoViewHelper());
          vhs.put("/les-codigo/PesquisarEndereco", new EnderecoViewHelper());
          vhs.put("/les-codigo/ExcluirEndereco", new EnderecoViewHelper());
          vhs.put("/les-codigo/PreAlterarEndereco", new EnderecoViewHelper());
          vhs.put("/les-codigo/AlterarEndereco", new EnderecoViewHelper());
          
          
          //mapeando 'operação' com instância para Command
          commands = new HashMap<String, ICommand>();
          commands.put("SALVAR", new SalvarCommand());
          commands.put("PESQUISAR", new PesquisarCommand());
          commands.put("EXCLUIR", new ExcluirCommand());
          commands.put("PREALTERAR", new PreAlterarCommand());
          commands.put("ALTERAR", new AlterarCommand());
        
        
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
        	
            response.setContentType("text/html;charset=UTF-8");
            //      try {
                
                //obtém nome do identificar do recurso (URI)
                String uri = request.getRequestURI();
                
                //cria instância de view helper de acordo com recurso de origem
                IViewHelper vh = vhs.get(uri);
                //obtém nome da operação de acordo com o 'value' do botão que foi apertado 
                String operacao = request.getParameter("operacao");
                //cria instância de tipo de command de acordo com identicação da operação
                ICommand command = commands.get(operacao);
                //recebe objeto da entidade domínio instanciada na chamada da view helper
                EntidadeDominio entidade = vh.getEntidade(request);
                //recebe mensagens e /ou lista de entidades de acordo com execução do tipo de command
                
                Resultado resultado = command.executar(entidade);
                
                System.out.println("chama setView");
                //chama view helper para ajustar o tipo de dados a serem exibidos na view
                vh.setView(resultado, request, response);    
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }
    
}
