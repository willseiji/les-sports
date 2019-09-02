package br.com.les.fachada.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.les.aplicacao.Resultado;
import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Pedido;
import br.com.les.dominio.impl.Produto;
import br.com.les.fachada.IFachada;
import br.com.les.servico.IServico;
import br.com.les.servico.impl.ClienteServico;
import br.com.les.servico.impl.EnderecoServico;
import br.com.les.servico.impl.PedidoServico;
import br.com.les.servico.impl.ProdutoServico;
import br.com.les.strategies.IStrategy;
import br.com.les.strategies.impl.StDadosCEPCliente;
import br.com.les.strategies.impl.StValidarCPF;
import br.com.les.strategies.impl.StValidarPeso;

public class Fachada implements IFachada {

	private Map<String, Map<String, List<IStrategy>>> rns;
    private Map<String, IDAO> daos;
    private Map<String,IServico> servicos;
    Resultado resultado = new Resultado();

	
	public Fachada() {
    	//--------------------------
    	//strategies para produto
		StValidarPeso vPeso = new StValidarPeso();
		
		//==========================================
        //cria lista de regras de negocio para salvar Produto
        List<IStrategy> rnsProdutoSalvar = new ArrayList<IStrategy>();
        rnsProdutoSalvar.add(vPeso);
        
      //cria lista de regras de negocio para pesquisar Produto
        List<IStrategy> rnsProdutoPesquisar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para pre Alterar Produto
        List<IStrategy> rnsProdutoPreAlterar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para Alterar Produto
        List<IStrategy> rnsProdutoAlterar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para Excluir Produto
        List<IStrategy> rnsProdutoExcluir = new ArrayList<IStrategy>();

    	//----------------------------
    	//strategies para cliente
        StValidarCPF vCPF = new StValidarCPF();
        
      //==========================================
        //cria lista de regras de negocio para salvar Produto
        List<IStrategy> rnsClienteSalvar = new ArrayList<IStrategy>();
        rnsClienteSalvar.add(vCPF);
        
      //cria lista de regras de negocio para pesquisar Produto
        List<IStrategy> rnsClientePesquisar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para pre Alterar Produto
        List<IStrategy> rnsClientePreAlterar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para Alterar Produto
        List<IStrategy> rnsClienteAlterar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para Excluir Produto
        List<IStrategy> rnsClienteExcluir = new ArrayList<IStrategy>();
        
    	//--------------------------------
    	//strategies para cliente
        StDadosCEPCliente vCEP = new StDadosCEPCliente();
        
        
        //==========================================
        //cria lista de regras de negocio para salvar Endereco
        List<IStrategy> rnsEnderecoSalvar = new ArrayList<IStrategy>();
        rnsEnderecoSalvar.add(vCEP);
        
      //cria lista de regras de negocio para pesquisar Endereco
        List<IStrategy> rnsEnderecoPesquisar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para pre Alterar Endereco
        List<IStrategy> rnsEnderecoPreAlterar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para Alterar Endereco
        List<IStrategy> rnsEnderecoAlterar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para Excluir Endereco
        List<IStrategy> rnsEnderecoExcluir = new ArrayList<IStrategy>();

      //==========================================
        //cria lista de regras de negocio para salvar Pedido
        List<IStrategy> rnsPedidoSalvar = new ArrayList<IStrategy>();
        
        
      //cria lista de regras de negocio para pesquisar Endereco
        List<IStrategy> rnsPedidoPesquisar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para pre Alterar Endereco
        List<IStrategy> rnsPedidoPreAlterar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para Alterar Endereco
        List<IStrategy> rnsPedidoAlterar = new ArrayList<IStrategy>();
        
        //cria lista de regras de negocio para Excluir Endereco
        List<IStrategy> rnsPedidoExcluir = new ArrayList<IStrategy>();
        
        //mapeando classes com lista de estrategies
        Map<String, List<IStrategy>> rnsProduto = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsCliente = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsEndereco = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsPedido = new HashMap<String, List<IStrategy>>();
        
        
        
        //-----------------------------------------------------
        //inserindo mapa de regras de negocios de acordo com suas operações
        rnsProduto.put("SALVAR", rnsProdutoSalvar);
        rnsProduto.put("PESQUISAR", rnsProdutoPesquisar);
        rnsProduto.put("PREALTERAR", rnsProdutoPreAlterar);
        rnsProduto.put("ALTERAR", rnsProdutoAlterar);
        rnsProduto.put("EXCLUIR", rnsProdutoExcluir);
        
        rnsCliente.put("SALVAR", rnsClienteSalvar);
        rnsCliente.put("PESQUISAR", rnsClientePesquisar);
        rnsCliente.put("PREALTERAR", rnsClientePreAlterar);
        rnsCliente.put("ALTERAR", rnsClienteAlterar);
        rnsCliente.put("EXCLUIR", rnsClienteExcluir);

        rnsEndereco.put("SALVAR", rnsEnderecoSalvar);
        rnsEndereco.put("PESQUISAR", rnsEnderecoPesquisar);
        rnsEndereco.put("PREALTERAR", rnsEnderecoPreAlterar);
        rnsEndereco.put("ALTERAR", rnsEnderecoAlterar);
        rnsEndereco.put("EXCLUIR", rnsEnderecoExcluir);
        
        rnsPedido.put("SALVAR", rnsPedidoSalvar);
        rnsPedido.put("PESQUISAR", rnsPedidoPesquisar);
        rnsPedido.put("PREALTERAR", rnsPedidoPreAlterar);
        rnsPedido.put("ALTERAR", rnsPedidoAlterar);
        rnsPedido.put("EXCLUIR", rnsPedidoExcluir);
        
        //rns = new HashMap<String, List<IStrategy>>();
        rns = new HashMap<String, Map<String, List<IStrategy>>>();
        rns.put(Produto.class.getName(), rnsProduto);
        rns.put(Cliente.class.getName(), rnsCliente);
        rns.put(Endereco.class.getName(), rnsEndereco);
        rns.put(Pedido.class.getName(), rnsPedido);
        
        
        //instanciando Servicos
        IServico servicoProduto = new ProdutoServico();
        IServico servicoCliente = new ClienteServico();
        IServico servicoEndereco = new EnderecoServico();
        IServico servicoPedido = new PedidoServico();
        
        //mapeando classes com Servicos
        servicos = new HashMap<String,IServico>();
        servicos.put(Produto.class.getName(),servicoProduto);
        servicos.put(Cliente.class.getName(),servicoCliente);
        servicos.put(Endereco.class.getName(),servicoEndereco);
        servicos.put(Pedido.class.getName(),servicoPedido);
        
	
	}

	public Resultado salvar(EntidadeDominio entidade) throws SQLException {
        String nmClass = entidade.getClass().getName();
        
        //executando validações de regras de negocio        
        String msg = executarRegras(entidade, "SALVAR");
        //chamando DAO em caso de todas as validações atendidas
        if (msg.isEmpty()) {
        	IServico servico = servicos.get(nmClass);
        	resultado.setEntidades(servico.salvar(entidade));
        	resultado.setMsg("dados salvos");
            //resultado.setMsg("Dados salvos no Banco de Dados");
            //List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
            //entidades.add(entidade);
            //resultado.setEntidades(entidades);
        	
        } else {
            resultado.setMsg(msg.toString());
        }
        return resultado;

	}

	public Resultado pesquisar(EntidadeDominio entidade) {
        String nmClass = entidade.getClass().getName();
        // instanciando DAO de acordo com a classe
        IServico servico = servicos.get(nmClass);
    	
        
        //IDAO dao = daos.get(nmClass);
        //executando validações de regras de negocio        
        String msg = executarRegras(entidade, "PESQUISAR");
        if (msg.isEmpty()) {
            if (servico.pesquisar(entidade).isEmpty()) {
                //caso dados não foram encontrados
                resultado.setMsg("dados nao encontrados");
            } else {
                //caso dados foram encontrados
                resultado.setMsg("pesquisa feita com sucesso");
            }
            
            resultado.setEntidades(servico.pesquisar(entidade));
        } else {
            resultado.setMsg(msg.toString());
        }
        return resultado;

	}

	public Resultado excluir(EntidadeDominio entidade) {
		String nmClass = entidade.getClass().getName();
        //executando validações de regras de negocio        
        String msg = executarRegras(entidade, "EXCLUIR");
        IServico servico = servicos.get(nmClass);
        
        if (msg.isEmpty()) {
        
        	resultado.setEntidades(servico.excluir(entidade));
            resultado.setMsg("Dados excluidos");
        } else {
            resultado.setMsg(msg.toString());
        }
        return resultado;	
    }

	public Resultado prealterar(EntidadeDominio entidade) {
		// identificando nome da classe
        String nmClass = entidade.getClass().getName();
        // instanciando DAO de acordo com a classe
        IServico servico = servicos.get(nmClass);
    	
        //executando validações de regras de negocio        
        String msg = executarRegras(entidade, "PREALTERAR");
        if (msg.isEmpty()) {
        	if (servico.prealterar(entidade)==null) {
                //caso dados não foram encontrados
                resultado.setMsg("dados nao encontrados");
            } else {
                //caso dados foram encontrados
                resultado.setMsg("");
            }
        	resultado.setEntidades(servico.prealterar(entidade));
            
        } else {
        	
            resultado.setMsg(msg.toString());
        }
        return resultado;
	}

	public Resultado alterar(EntidadeDominio entidade) {
        // identificando nome da classe
        String nmClass = entidade.getClass().getName();
        IServico servico = servicos.get(nmClass);
        
        //executando validações de regras de negocio        
        String msg = executarRegras(entidade, "ALTERAR");
        
        
        //chamando DAO em caso de todas as validações atendidas
        if (msg.isEmpty()) {
        	resultado.setEntidades(servico.alterar(entidade));
            resultado.setMsg("Dados alterados");
           // resultado.setEntidades(servico.prealterar(entidade));
        } else {
            resultado.setMsg(msg.toString());
            
        }
        return resultado;

	}
	
	private String executarRegras(EntidadeDominio entidade, String operacao) {
        // identificando nome da classe
        String nmClasse = entidade.getClass().getName();
        //para construção de String de mensagens
        StringBuilder msg = new StringBuilder();
        //mapeando classes com lista de estrategies
        Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
        //caso tenha regras de negocio associada à classe
        if (!regrasOperacao.isEmpty()) {
            List<IStrategy> regras = regrasOperacao.get(operacao);
            //caso tenha regras de negocio associada à operação da classe
            if (!regras.isEmpty()) {
                for (IStrategy s : regras) {
                    //checando mensagens de regras de negocio
                    String m = s.processar(entidade);
                    if (!m.isEmpty()) {
                        //adicionando mensagens na StringBuilder
                        msg.append(m);
                    }
                }
            }
        }
        if (msg.length() > 0) {
            return msg.toString();
        } else {
            return "";
        }
    }

}
