package br.com.les.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.les.dao.ConnectionFactory;
import br.com.les.dao.IDAO;
import br.com.les.dominio.impl.Cliente;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Usuario;

public class UsuarioDAO implements IDAO {

	
	
	@Override
	public int salvar(EntidadeDominio entidade) throws SQLException {
		
		Usuario u = (Usuario) entidade;
		int id_Usuario=0;
		
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
        String sql = "INSERT INTO usuario(nome, senha, id_cliente) "
        		+ " VALUES(?,?,?)";
        //determinando valores a serem encontrados no banco de dados
        
        try {
            //comando inserido no SGBD
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getId_cliente());
            
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            
           while(rs.next()) {
            	id_Usuario=rs.getInt(1);
            
            }
            rs.close();
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
            //JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

		
		return id_Usuario;

	}

	@Override
	public List<EntidadeDominio> pesquisar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio prealterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
