package testes;

import java.util.List;

import dao.ClienteDao;
import modelo.Cliente;

public class TesteGetClientes {
	public static void main(String[] args) {
		
		ClienteDao dao = new ClienteDao();
		
		try {			
			List<Cliente> clientes = dao.getClientes();

			for (Cliente cliente : clientes) {
				System.out.println("Id: " + cliente.getId());
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("E-mail: " + cliente.getEmail());
				System.out.println("Endereço: " + cliente.getEndereco());
				System.out.println("--------------------------------------");
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dao.FecharConexao();
		}
				

		
	}
}
