package teste;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.les.dao.impl.ClienteDAO;
import br.com.les.dao.impl.EnderecoDAO;
import br.com.les.dao.impl.ItemDAO;
import br.com.les.dominio.impl.CartaoCredito;
import br.com.les.dominio.impl.Cidade;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Estado;
import br.com.les.dominio.impl.ItemTroca;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Troca;
import br.com.les.dominio.impl.Usuario;
import br.com.les.servico.impl.CartaoServico;
import br.com.les.servico.impl.ClienteServico;
import net.sf.json.JSONObject;

public class Teste{

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*
		Produto produto = new Produto();
		produto.setNome("agasalho2");
		produto.setCategoria("roupa");
		produto.setMaterial("lã");
		produto.setPeso(500);
		produto.setTamanho("G");
		produto.setFabricante("casa da vo");
		
		*/
		/*
		Cliente cliente = new Cliente();
		cliente.setNome("Joao");
		cliente.setDtNasc("02/02/2002");
		cliente.setSexo("Masculino");
		cliente.setRg("123456789");
		cliente.setCpf("12345678912");
		cliente.setEmail("joao@gmail.com");
		cliente.setTelefone("123456");
		
		Usuario usuario = new Usuario();
		usuario.setNome("joao");
		usuario.setSenha("123");
		
		cliente.setUsuario(usuario);
		Endereco e = new Endereco();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		
		e.setRua("XXXXX");
		e.setNumero("30");
		e.setComplemento("bloco D");
		e.setBairro("Vila Paulista");
		e.setCep("0003330");
		
		cidade.setNome("São Paulo");
		estado.setNome("SP");
		cidade.setEstado(estado);
		e.setCidade(cidade);
		e.setTipoEndereco("entrega");
		
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(e);
		cliente.setEnderecos(enderecos);
		
		ClienteServico servicoCliente = new ClienteServico();
		
		EntidadeDominio entidadeSalvar = (EntidadeDominio) cliente;
		List<EntidadeDominio> entidades = servicoCliente.salvar(entidadeSalvar);
		*/
		/*
		int id_pedido=7;
		ItemDAO daoItem = new ItemDAO();
		List<EntidadeDominio> entidades = daoItem.findByIdPedido(id_pedido);
		System.out.println(entidades);
		*/
		/*
		int id = 7;
		System.out.println("inicio de codigo");
		String stValorId = String.format("%08d",id);
		System.out.println("inicio de codigo");
		//String initCateg = nome.substring(0, 3);
        //String code = initCateg.toUpperCase()+stValorId;
		String code = stValorId;
        System.out.println("codigo gerado: "+code);
        */
		/*
		CartaoCredito cartao = new CartaoCredito();
		CartaoServico servicoCartao = new CartaoServico();
		int id_cliente=5;
			cartao.setBandeira("VISA");
			cartao.setNumero("55557777");
			cartao.setCodigoSeguranca("147");
			cartao.setDataValidade("05/01/2020");
			cartao.setNomeTitular("Maria XXX");
		cartao.setPrincipal("Não");
		cartao.setId_cliente(id_cliente);
		servicoCartao.salvar(cartao);
		
		*/
		
		/*
		String valor_json = "{"+"cartoes"+":[{id: "+1+", parcela:"+100+"},{id: "+2+", parcela:"+300+"}]}";
		
		//System.out.println(valor_json);
		
		JsonObject jsonObject = new JsonParser().parse(valor_json).getAsJsonObject();
		int tamanho = jsonObject.getAsJsonArray("cartoes").size();
		for(int i=0;i<tamanho;i++) {
			JsonObject item_cartao = (JsonObject) jsonObject.getAsJsonArray("cartoes").get(i);
			System.out.println(item_cartao.getAsJsonObject().get("id"));
			System.out.println(item_cartao.getAsJsonObject().get("parcela"));
		}
		*/
		/*
		Troca troca = new Troca();
		
		ItemTroca itemTroca1 = new ItemTroca();
		ItemTroca itemTroca2 = new ItemTroca();
		List<ItemTroca> itensTroca = new ArrayList<>();
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		
		
		
		itemTroca1.setPreco(160);
		itemTroca1.setQtdeTrocada(2);
		
		itemTroca2.setPreco(110.0);
		itemTroca2.setQtdeTrocada(3);
		
		itensTroca.add(itemTroca1);
		itensTroca.add(itemTroca2);
		
		troca.setItensTroca(itensTroca);
		
		
		System.out.println("qtde de troca 1: "+itemTroca1.getQtdeTrocada());
		System.out.println("preco de troca 1: "+itemTroca1.getPreco());
		System.out.println("total de troca 1: "+itemTroca1.valorTroca());
		
		//System.out.println("valor de troca 2: "+itemTroca2.getValor_troca());
		*/
		
		
		 DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	        Date date = new Date();
	        System.out.println(sdf.format(date));
	    
		
	}

}
