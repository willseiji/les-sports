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
import br.com.les.dominio.impl.Cidade;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.Endereco;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Estado;

public class EnderecoDAO implements IDAO {

	@Override
	public int salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("inicio dao endereco");
				Endereco e = (Endereco) entidade;
				int id_Endereco=0;
				
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
		        System.out.println("conexao realizada");
		        
		        //comando SQL a ser feito
		        String sql = "INSERT INTO endereco (rua,numero,complemento, bairro, cep, cidade, estado,tipo_endereco) "
		        	+ " VALUES(?,?,?,?,?,?,?,?)";
		        //determinando valores a serem encontrados no banco de dados
		        
		        String cidade = e.getCidade().getNome();
		        String estado = e.getCidade().getEstado().getNome();
		        String rua = e.getRua();
		        
		        
		        try {
		            //comando inserido no SGBD
		            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		            stmt.setString(1, e.getRua());
		            stmt.setString(2, e.getNumero());
		            stmt.setString(3, e.getComplemento());
		            stmt.setString(4, e.getBairro());
		            stmt.setString(5, e.getCep());
		            stmt.setString(6, cidade);
		            stmt.setString(7, estado);
		            stmt.setString(8, e.getTipoEndereco());
		            stmt.executeUpdate();
		            rs = stmt.getGeneratedKeys();
		           while(rs.next()) {
		            	id_Endereco=rs.getInt(1);
		            	
		            }
		            rs.close();
		            //JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		        } catch (SQLException ex) {
		            System.out.println("Erro ao salvar: " + ex);
		            //JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
		        } finally {
		            ConnectionFactory.closeConnection(con, stmt);
		        }

				
				return id_Endereco;
	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
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
        Endereco e = (Endereco) entidade;
        List<EntidadeDominio> enderecos = new ArrayList<>();
        
        
        //comando SQL a ser feito
        
        String filtro = Integer.toString(e.getId());
        try {
        	String sql = "SELECT * FROM endereco WHERE endereco.id_endereco like '%" + filtro+"%'";
            System.out.println("filtro: "+filtro);
            System.out.println("sql: "+sql);
            
        	System.out.println("dentro de try");
            //comando inserido no SGBD
            stmt = con.prepareStatement(sql);
            System.out.println("statement: "+stmt);
            //stmt.setString(1, filtro);
            System.out.println("antes de execute");
            rs = stmt.executeQuery();
            System.out.println("rs: "+rs.next());
            System.out.println("depois de execute");
            System.out.println("-----------------");
            System.out.println("teste2: "+rs.getInt("endereco.id_endereco"));
            System.out.println("teste2rua: "+rs.getString("endereco.rua"));
            //lendo vários dados
            //if(rs.next()) {
	            Cidade cidade = new Cidade();
	        	Estado estado = new Estado();
	        	Endereco endereco = new Endereco();
	                    
	        	
	        	endereco.setId(rs.getInt("endereco.id_endereco"));
	            endereco.setRua(rs.getString("endereco.rua"));
	            endereco.setNumero(rs.getString("endereco.numero"));
	            endereco.setComplemento(rs.getString("endereco.complemento"));
	            endereco.setBairro(rs.getString("endereco.bairro"));
	            endereco.setCep(rs.getString("endereco.cep"));
	            cidade.setNome(rs.getString("endereco.cidade"));
	            estado.setNome(rs.getString("endereco.estado"));
	            cidade.setEstado(estado);
	            endereco.setCidade(cidade);
	            endereco.setTipoEndereco(rs.getString("endereco.tipo_endereco"));
	            
	            enderecos.add(endereco);
            //}else {
            	//Endereco endereco = new Endereco();
            	//enderecos.add(endereco);
            	
            //}
            	
            /*
            while (rs.next()) {
            	System.out.println("*************");
                
            	System.out.println("dentro de while");
            	
            	Cidade cidade = new Cidade();
            	Estado estado = new Estado();
            	Endereco endereco = new Endereco();
                        
            	
            	endereco.setId(rs.getInt("endereco.id_endereco"));
                endereco.setRua(rs.getString("endereco.rua"));
                endereco.setNumero(rs.getString("endereco.numero"));
                endereco.setComplemento(rs.getString("endereco.complemento"));
                endereco.setBairro(rs.getString("endereco.bairro"));
                endereco.setCep(rs.getString("endereco.cep"));
                cidade.setNome(rs.getString("endereco.cidade"));
                estado.setNome(rs.getString("endereco.estado"));
                cidade.setEstado(estado);
                endereco.setCidade(cidade);
                endereco.setTipoEndereco(rs.getString("endereco.tipo_endereco"));
            	//Endereco endereco = null;
                //enderecos.add(endereco);
                
            	System.out.println("dados lidos");
            }
            	*/
        } catch (SQLException ex) {
            System.out.println("falha de leitura");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //retornando dados lidos
        System.out.println("===========-----------============");
        
        System.out.println("size de enderecos na DAO: "+enderecos.size());
        
        return enderecos;
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			con = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PreparedStatement stmt=null;
        ResultSet rs = null;
        Endereco e = (Endereco) entidade;
        String filtro = Integer.toString(e.getId());
        //comando SQL a ser feito
        String sql = "DELETE FROM endereco WHERE id_endereco = "+ filtro;
        System.out.println("sql: "+sql);
            try {
				stmt = con.prepareStatement(sql);
				//stmt.setInt(1, p.getId());
	            stmt.executeUpdate();
	            System.out.println("excluido com sucesso");
	        
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
        
	}

}
