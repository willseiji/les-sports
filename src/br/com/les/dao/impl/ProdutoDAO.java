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
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.dominio.impl.Produto;

public class ProdutoDAO implements IDAO {

	@Override
	public int salvar(EntidadeDominio entidade) throws SQLException {
		Produto p = (Produto) entidade;
		int idProduto=0;
		Connection con=null;
		try {
			con = ConnectionFactory.getConnection();
			System.out.println("conexao realizada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conexao recusada");
			e.printStackTrace();
		}
		
		//criando statemment
        PreparedStatement stmt = null;
        ResultSet rs;
        System.out.println("conexao");
        System.out.println("nome do material: "+p.getMaterial());
        
        //comando SQL a ser feito
        String sql = "INSERT INTO produto (codigo, nome, material,categoria,tamanho, peso, fabricante,descricao,status) "
        		+ " VALUES(?,?,?,?,?,?,?,?,?)";
        //determinando valores a serem encontrados no banco de dados
        try {
        	System.out.println("statement dentro do try2");
            //comando inserido no SGBD
        	stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        	stmt.setString(1, geradorCodigo(p.getNomeProd()));
            stmt.setString(2, p.getNomeProd());
            stmt.setString(3, p.getMaterial());
            stmt.setString(4, p.getCategoria());
            stmt.setString(5, p.getTamanho());
            stmt.setDouble(6, p.getPeso());
            stmt.setString(7, p.getFabricante());
            stmt.setString(8, p.getDescricao());
            stmt.setString(9, "INATIVO");
            
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            
           while(rs.next()) {
            	idProduto=rs.getInt(1);
            }
            rs.close();
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
            //JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return idProduto;
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
        List<EntidadeDominio> produtos = new ArrayList<EntidadeDominio>();
        //cast de Peca
        Produto p = (Produto) entidade;
        //comando SQL a ser feito
        String filtro = p.getDescricao();
        System.out.println("filtro: "+filtro);
        
        try {
        	String sql = "SELECT * FROM produto";
        
            if(filtro!="") {
            	sql =sql + "WHERE produto.codigo like ? OR produto.nome like ? OR produto.material like ? "
            			+ "OR produto.fabricante ?"
            			;
            	//comando inserido no SGBD
            	stmt = con.prepareStatement(sql);
            	stmt.setString(1, '%'+filtro+'%');
            	stmt.setString(2, '%'+filtro+'%');
            	stmt.setString(3, '%'+filtro+'%');
            	stmt.setString(4, '%'+filtro+'%');
            	
            }
            else
            	stmt = con.prepareStatement(sql);
            System.out.println("sql: "+sql);
            
            rs = stmt.executeQuery();
            //lendo vários dados
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("produto.id_produto"));
                produto.setCodigoProd(rs.getString("produto.codigo"));
                produto.setNomeProd(rs.getString("produto.nome"));
                produto.setMaterial(rs.getString("produto.material"));
                produto.setDescricao(rs.getString("produto.descricao"));
                produto.setPeso(rs.getDouble("produto.peso"));
                produto.setTamanho(rs.getString("produto.tamanho"));
                produto.setCategoria(rs.getString("produto.categoria"));
            	produto.setFabricante(rs.getString("produto.fabricante"));
            	produto.setStatus(rs.getString("produto.status"));
            	produto.setPreco(rs.getDouble("produto.preco"));
            	produto.setQuantidade(rs.getInt("produto.quantidade"));
            	
                produtos.add(produto);
                
            }
        } catch (SQLException ex) {
            System.out.println("falha de leitura");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //retornando dados lidos
        return produtos;

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
        Produto p = (Produto) entidade;
        Produto produto = new Produto();
        List<EntidadeDominio> produtos = new ArrayList<EntidadeDominio>();
        
        //comando SQL a ser feito
        
        String filtro = p.getCodigoProd();
        String sql = "SELECT * FROM produto WHERE produto.codigo like '%" + filtro+"%'";
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
            	produto.setCodigoProd(rs.getString("produto.codigo"));
                produto.setNomeProd(rs.getString("produto.nome"));
                produto.setMaterial(rs.getString("produto.material"));
                produto.setCategoria(rs.getString("produto.categoria"));
                produto.setPeso(rs.getDouble("produto.peso"));
                produto.setTamanho(rs.getString("produto.tamanho"));
                produto.setFabricante(rs.getString("produto.fabricante"));
            	produto.setDescricao(rs.getString("produto.descricao"));
            	produto.setStatus(rs.getString("produto.status"));
            	produto.setPreco(rs.getDouble("produto.preco"));
            	produto.setQuantidade(rs.getInt("produto.quantidade"));
            	produtos.add(produto);
            	System.out.println("dados lidos");
            }
        } catch (SQLException ex) {
            System.out.println("falha de leitura");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        System.out.println("Nome: "+produto.getNomeProd());
        System.out.println("Categoria: "+produto.getCategoria());
        System.out.println("Material: "+produto.getMaterial());
        //retornando dados lidos
        return produtos;
	}

		@Override
		public void alterar(EntidadeDominio entidade) {
			Produto p = (Produto) entidade;
	        //fazendo conexão com Factory
	        Connection con=null;
			try {
				con = ConnectionFactory.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //criando statemment
	        PreparedStatement stmt = null;
	        System.out.println("codigo do produto em dao alterar: "+p.getCodigoProd());
	        String codigo = p.getCodigoProd();
	        
	        //comando SQL a ser feito
	        String sql = "UPDATE produto SET "
	        		+ "produto.nome=?, produto.material=?, produto.peso=?, produto.tamanho=?, produto.categoria=?, "
	        		+ "  produto.fabricante=?,produto.descricao=?, produto.status=?"
	        		+ "WHERE produto.codigo like '%"+codigo+"%'";
	        //determinando valores a serem encontrados no banco de dados
	        
	        try {
	            //comando inserido no SGBD
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, p.getNomeProd());
	            stmt.setString(2, p.getMaterial());
	            stmt.setDouble(3, p.getPeso());
	            stmt.setString(4, p.getTamanho());
	            stmt.setString(5, p.getCategoria());
	            stmt.setString(6, p.getFabricante());
	            stmt.setString(7, p.getDescricao());
	            stmt.setString(8, p.getStatus());
	            
	            stmt.executeUpdate();
	            //JOptionPane.showMessageDialog(null, "Salvo com sucesso");
	        } catch (SQLException ex) {
	            System.out.println("Erro ao salvar: " + ex);
	            //JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt);
	        }


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
        String sql = "select id_produto from produto "
        		+ "order by produto.id_produto desc limit 1";
        int valorId=0;
        String initCateg=null;
        try {
            //comando inserido no SGBD
        	stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
            	valorId = rs.getInt("id_produto")+1;
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

