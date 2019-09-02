package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import br.com.les.dao.impl.ClienteDAO;
import br.com.les.dao.impl.EnderecoDAO;
import br.com.les.dao.impl.Produto2DAO;
import br.com.les.dominio.impl.Cidade;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Estado;
import br.com.les.dominio.impl.Produto;
import br.com.les.dominio.impl.Usuario;
import br.com.les.servico.impl.ClienteServico;

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
		
		
	}

}
