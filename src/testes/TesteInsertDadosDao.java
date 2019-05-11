package testes;

import dao.ClienteDao;
import modelo.Cliente;

public class TesteInsertDadosDao {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		cliente.setNome("Joao");
		cliente.setEmail("joao@joao.com");
		cliente.setEndereco("Rua Joao, 2");
		
		ClienteDao dao = new ClienteDao();
		try {
			dao.insert(cliente);
			System.out.println("Cliente gravado com sucesso!");
		} catch (Exception e) {
			System.out.println("erro ao gravar Cliente!");			
		} finally {
			dao.fecharConexao();
		}
		
	}
}
