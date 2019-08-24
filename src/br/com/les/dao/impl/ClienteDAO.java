package br.com.les.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.ConnectionFactory;
import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;

public class ClienteDAO implements IDAO {

	@Override
	public int salvar(EntidadeDominio entidade) throws SQLException {
		Cliente c = (Cliente) entidade;
		int id_Cliente=0;
		
		Connection con=null;
		try {
			con = ConnectionFactory.getConnection();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("conexao recusada");
			ex.printStackTrace();
		}
		
		//criando statemment
        PreparedStatement stmt = null;
        ResultSet rs;
        
        //comando SQL a ser feito
        String sql = "INSERT INTO cliente(codigo, nome, sexo, data_nasc, rg, cpf, telefone, email,status,id_endereco) "
        		+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
        //determinando valores a serem encontrados no banco de dados
        
        try {
            //comando inserido no SGBD
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, geradorCodigo(c.getNome()));
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getSexo());
            stmt.setString(4, c.getDtNasc());
            stmt.setString(5, c.getRg());
            stmt.setString(6, c.getCpf());
            stmt.setString(7, c.getTelefone());
            stmt.setString(8, c.getEmail());
            stmt.setString(9, "ATIVO");
            stmt.setInt(10, c.getEnderecos().get(0).getId());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            
           while(rs.next()) {
            	id_Cliente=rs.getInt(1);
            
            }
            rs.close();
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
            //JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

		
		return id_Cliente;
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EntidadeDominio> prealterar(EntidadeDominio entidade) {
		System.out.println("dao prealterar");
        Connection con=null;

		try {
			con = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //criando statemment
        PreparedStatement stmt = null;
        //criando result de dados obtidos de banco de dados
        ResultSet rs = null;
        //cast de Peca
        Cliente c = (Cliente) entidade;
        Cliente cliente = new Cliente();
        List<EntidadeDominio> clientes = new ArrayList<>();
        
        //comando SQL a ser feito
        
        String filtro = c.getCodigo();
        String sql = "SELECT * FROM cliente WHERE cliente.codigo like '%" + filtro+"%'";
        System.out.println("filtro: "+filtro);
        System.out.println("sql: "+sql);
        try {
        	System.out.println("dentro de try");
            //comando inserido no SGBD
            stmt = con.prepareStatement(sql);
            System.out.println("statement");
            //stmt.setString(1, filtro);
            System.out.println("antes de execute");
            rs = stmt.executeQuery();
            System.out.println("rs: ");
            System.out.println("depois de execute");
            //lendo vários dados
            while (rs.next()) {
            	System.out.println("dentro de while");
            	cliente.setId(rs.getInt("cliente.id_cliente"));
                cliente.setCodigo(rs.getString("cliente.codigo"));
                cliente.setNome(rs.getString("cliente.nome"));
                cliente.setDtNasc(rs.getString("cliente.data_nasc"));
                cliente.setSexo(rs.getString("cliente.sexo"));
                cliente.setRg(rs.getString("cliente.rg"));
                cliente.setCpf(rs.getString("cliente.cpf"));
                cliente.setEmail(rs.getString("cliente.email"));
                cliente.setTelefone(rs.getString("cliente.telefone"));
                cliente.setStatus(rs.getString("cliente.status"));
            	clientes.add(cliente);
            	
            	System.out.println("dados lidos");
            }
        } catch (SQLException ex) {
            System.out.println("falha de leitura");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //retornando dados lidos
        return clientes;
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		Connection con=null;
		try {
			con = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //criando statemment
        PreparedStatement stmt = null;
        //criando result de dados obtidos de banco de dados
        ResultSet rs = null;
        //criando list de dados lidos
        List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>();
        //cast de Cliente
        Cliente c = (Cliente) entidade;
        
        //comando SQL a ser feito
        String filtro = c.getNome();
        System.out.println("filtro: "+filtro);
        
        try {
        	String sql = "SELECT * FROM cliente";
        
            if(filtro!="") {
            	sql =sql + "WHERE cliente.codigo like ? OR cliente.nome like ? "
            			;
            	//comando inserido no SGBD
            	stmt = con.prepareStatement(sql);
            	stmt.setString(1, '%'+filtro+'%');
            	stmt.setString(2, '%'+filtro+'%');
            	
            }
            else
            	stmt = con.prepareStatement(sql);
            System.out.println("sql: "+sql);
            
            rs = stmt.executeQuery();
            //lendo vários dados
            while (rs.next()) {
            	
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cliente.id_cliente"));
                cliente.setCodigo(rs.getString("cliente.codigo"));
                cliente.setNome(rs.getString("cliente.nome"));
                cliente.setEmail(rs.getString("cliente.email"));
            	cliente.setStatus(rs.getString("cliente.status"));
            	System.out.println("leitura feita");
            	
            	
            	clientes.add(cliente);
                
            }
        } catch (SQLException ex) {
            System.out.println("falha de leitura");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //retornando dados lidos
        return clientes;
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	public String geradorCodigo(String nome) {
		Connection con=null;
		String code = null;
		try {
			con = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //criando statemment
        PreparedStatement stmt = null;
        //criando result de dados obtidos de banco de dados
        ResultSet rs = null;
        //criando list de dados lidos
        //comando SQL a ser feito
        String sql = "select id_cliente from cliente "
        		+ "order by cliente.id_cliente desc limit 1";
        int valorId=0;
        String initCateg=null;
        try {
            //comando inserido no SGBD
        	stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
            	valorId = rs.getInt("id_cliente")+1;
            	initCateg = nome.substring(0, 3);
            }
            String stValorId = String.format("%05d",valorId);
            System.out.println("iniciais: "+initCateg);
            System.out.println("valorId: "+stValorId);
            code = initCateg.toUpperCase()+stValorId;
            
        } catch (SQLException ex) {
            System.out.println("falha de leitura");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return code;
	}
}
