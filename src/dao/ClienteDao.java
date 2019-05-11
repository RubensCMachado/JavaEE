package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javadb.jdbc.ConnectionFactory;
import modelo.Cliente;

public class ClienteDao {
	private Connection con;
	
	public ClienteDao() {
		this.con = new ConnectionFactory().GetConnection();
	}
	
	public void FecharConexao() {
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Cliente cliente) {
		String sql = "INSERT INTO clientes(nome, email, endereco) VALUES(?,?,?)";	
		try {
			PreparedStatement stmt = con.prepareStatement(sql);			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());			
			stmt.execute();
			stmt.close();							
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> getClientes() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM clientes");					
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				
				clientes.add(cliente);
			}
			
			rs.close();
			stmt.close();	
			
			return clientes;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}

}
